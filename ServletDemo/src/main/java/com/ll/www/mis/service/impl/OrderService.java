package com.ll.www.mis.service.impl;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ll.www.mis.dao.OrderDao;
import com.ll.www.mis.entity.Order;
import com.ll.www.mis.service.IOrderService;

public class OrderService implements IOrderService {

	private OrderDao dao;

	// 添加或修改
	public void Update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			dao = new OrderDao(); // 每次初始化打开连接;
			String idstr = request.getParameter("id");
			Order entity = new Order();
			if (idstr != "" && idstr != null) {
				Long id = Long.parseLong(idstr);
				entity = dao.SelectById(id);
			}

			request.setAttribute("entity", entity);
			request.getRequestDispatcher("/Order/input.jsp").forward(
					request, response);
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	// 保存
	public void Save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			dao = new OrderDao(); // 每次初始化打开连接;

			String idstr = request.getParameter("id");
 

			String name=request.getParameter("name");
			String startTime=request.getParameter("startTime");
			String price=request.getParameter("price");
			

			//日期转换 
			Date toDate = null;
			if (!startTime.equals("")) {
				try {
					toDate = java.sql.Date.valueOf(startTime);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			Order entity = new Order();

			entity.setName(name);
			entity.setStartTime(toDate);
			entity.setPrice(Float.valueOf(price));

			if (idstr.endsWith("null")) {
				dao.Insert(entity);
			} else {
				entity.setId(Long.parseLong(idstr));
				dao.Update(entity);
			}

			request.setAttribute("entity", entity);
			request.getRequestDispatcher("/Order/input.jsp").forward(
					request, response);
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	// 删除
	public void Delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			dao = new OrderDao(); // 每次初始化打开连接;
			String idstr = request.getParameter("id");

			if (idstr != "" && idstr != null) {
				Long id = Long.parseLong(idstr);
				dao.Delete(id);
			}

			SelectAll(request, response);
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	// 查询全部
	public void SelectAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			dao = new OrderDao(); // 每次初始化打开连接;
			List list = dao.SelectAll();
			request.setAttribute("listall", list);
			request.getRequestDispatcher("/Order/list.jsp").forward(request,
					response);
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	// 组合查询
	public void SelectByPar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

 

		String name=request.getParameter("name");
		String startTime=request.getParameter("startTime");
		String price=request.getParameter("price");
		

		//日期转换 
		Date toDate = null;
		if (startTime!=null&&!startTime.equals("")) {
			try {
				toDate = java.sql.Date.valueOf(startTime);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Order entity = new Order();

		entity.setName(name);
		entity.setStartTime(toDate);
		if(price!=null&&price!="")
		{
			entity.setPrice(Float.valueOf(price));
		}
		
		try {

			dao = new OrderDao(); // 每次初始化打开连接;
			List list = dao.SelectByPar(entity);
			request.setAttribute("listall", list);
			request.getRequestDispatcher("/Order/list.jsp").forward(request,
					response);
		}

		catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
