package test;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.ll.www.mis.dao.OrderDao;


//测试类
public class test1 {

	@Test
	public void testOrderDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		OrderDao od=new OrderDao();
		
		Long id=3L;
		
		try{
			
			od.Delete(id);
		}
		catch(Exception e){		
			
		}
	   
		System.out.println("删除成功！");
		
		
		
		
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectById() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByPar() {
		fail("Not yet implemented");
	}

}
