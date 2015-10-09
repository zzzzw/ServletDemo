package com.ll.www.mis.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

 

import com.ll.www.mis.entity.Order;

/**
 * @author 操作数据库
 */
public class OrderDao {
	
	private Connection con;
	private PreparedStatement pre;
	private ResultSet rs;

	private String fileName="/db.properties";
	
	// 查询字符串
	private StringBuffer SelectByParStr = new StringBuffer("select * from x_order where 1=1");
	
	private static String SelectByIdStr = "select * from x_order where id=?";
	private static String SelectAllStr = "select * from x_order order by id desc";
	private static String InsertStr = "insert into x_order(name,startTime,price) values(?,?,?)";
	private static String UpdateStr = "update x_order set name=?,startTime=?,price=? where id=?";
	private static String DeleteStr = "delete from x_order where id=?";

	//获取配置
	private List<String> getPropertier()
	{
		List<String> result=new ArrayList<String>();
		 Properties p = new Properties();  
         try {  
             InputStream in = OrderDao.class.getResourceAsStream(fileName); 
             p.load(in);  
             in.close();  
             if(p.containsKey("jdbc.driverClassName")){  
                 result.add(p.getProperty("jdbc.driverClassName"));  
             }  
             if(p.containsKey("jdbc.url")){  
            	 result.add(p.getProperty("jdbc.url"));  
             }  
             if(p.containsKey("jdbc.username")){  
            	 result.add(p.getProperty("jdbc.username"));  
             }  
             if(p.containsKey("jdbc.password")){  
            	 result.add(p.getProperty("jdbc.password"));   
             }  
         } catch (IOException ex) {  
             
         }  
		
		return result;
	}
	
	// 打开数据库连接
	private void OpenConnection() {
		if (con == null) {
			try {

				Class.forName(getPropertier().get(0));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				String url = getPropertier().get(1);
				String user = getPropertier().get(2);
				String password =getPropertier().get(3);
				con = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 关闭数据库连接
	private void CloseConnection() throws SQLException {
		if (pre != null)
			pre.close();
		if (con != null)
			con.close();
	}

	// 初始化
	public OrderDao() {
		OpenConnection();
	}

	// 删除
	public int Delete(Long id) throws SQLException {
		int count = 0;
		pre = con.prepareStatement(DeleteStr);
		pre.setLong(1, id);
		count = pre.executeUpdate();
		CloseConnection();
		return count;
	}

	// 添加
	public int Insert(Order entity) throws SQLException {
		int count = 0;
		pre = con.prepareStatement(InsertStr);

		pre.setString(1, entity.getName()); 
		
		pre.setDate(2, entity.getStartTime());
		pre.setFloat(3, entity.getPrice());
		count = pre.executeUpdate();

		CloseConnection();
		return count;
	}

	// 更新
	public int Update(Order entity) throws SQLException {
		int count = 0;
		pre = con.prepareStatement(UpdateStr);
		pre.setString(1, entity.getName());
		
        
		pre.setDate(2, entity.getStartTime());
		pre.setFloat(3, entity.getPrice());
		pre.setLong(4, entity.getId());
		count = pre.executeUpdate();
		CloseConnection();
		return count;
	}

	// 按ID查询,返回实体
	public Order SelectById(Long id) throws SQLException {
		Order entity = new Order();
		pre = con.prepareStatement(SelectByIdStr);
		pre.setLong(1, id);
		rs = pre.executeQuery();
		while (rs.next()) {
			entity.setId(rs.getLong("id"));
			entity.setName(rs.getString("name"));
			entity.setStartTime(rs.getDate("startTime"));
			entity.setPrice(rs.getFloat("price"));
		}
		CloseConnection();
		return entity;

	}

	// 查询全部
	public List<Order> SelectAll() throws SQLException {

		List<Order> list = new ArrayList<Order>();
		pre = con.prepareStatement(SelectAllStr);
		rs = pre.executeQuery();
		while (rs.next()) {
			Order entity = new Order();
			entity.setId(rs.getLong("id"));
			entity.setName(rs.getString("name"));
			entity.setStartTime(rs.getDate("startTime"));
			entity.setPrice(rs.getFloat("price"));
			list.add(entity);
		}
		CloseConnection();
		return list;
	}

	// 组合查询
	public List<Order> SelectByPar(Order entity) throws SQLException {

		List<Order> list = new ArrayList<Order>();

		// 准备查询条件
		List values = new ArrayList();
		if (entity.getName() != "") {
			SelectByParStr.append(" and name like ?");
			values.add("%" + entity.getName() + "%");
		}
		 
		if (entity.getStartTime() != null) {
			SelectByParStr.append(" and startTime = ?");
			values.add(entity.getStartTime());
		}
		if (entity.getPrice()!=null&&entity.getPrice()>0) {
			SelectByParStr.append(" and price <= ?");  //float类型不能判断相等，不要设计float字段
			values.add(entity.getPrice());
		}
		pre = con.prepareStatement(SelectByParStr.toString());
		if (values != null) {
			for (int i = 0; i < values.size(); i++) {
				pre.setObject(i + 1, values.get(i)); // 参数索引从1开始
			}
		}

		rs = pre.executeQuery();
		while (rs.next()) {
			Order fentity = new Order();
			fentity.setId(rs.getLong("id"));
			fentity.setName(rs.getString("name"));
			fentity.setStartTime(rs.getDate("startTime"));
			fentity.setPrice(rs.getFloat("price"));
			list.add(fentity);
		}
		CloseConnection();
		return list;
	}
}
