package com.ll.www.mis.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ll.www.mis.service.IOrderService;
import com.ll.www.mis.service.impl.OrderService;

/**
 * @author liulei
 *Servlet 流程转发
 */
public class OrderServlet extends HttpServlet{
     private static final long serialVersionUID =1L;
     private IOrderService service=new OrderService();
     
	 public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	 {	 
     	 String method=request.getParameter("method");
		 int m=Integer.parseInt(method);
		  
			 switch(m)
			 {
			 case 0:  //查询全部
				 service.SelectAll(request, response);
			     break;
			 case 1:  //组合查询
				 service.SelectByPar(request, response);
			     break;
			 case 2:  //新增或修改
				 service.Update(request, response);
			     break;
			 case 3:  //保存
				 service.Save(request, response);
			     break;
			 case 4:  //删除
				 service.Delete(request, response);
			     break;
			 
			 }
		 
		
	 }
	 
	    //doGet方法
		public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	       doPost(request,response);
	    }

}
