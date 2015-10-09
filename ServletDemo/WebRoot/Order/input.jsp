<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType = "text/html;charset=UTF-8"%>
<%@page import="com.ll.www.mis.entity.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Order entity=(Order)request.getAttribute("entity");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>JSP+Servlet+JDBC测试</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path%>/admin/skin/css/table.css">
	 <script src="<%=path%>/resources/components/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
  </head>
  
  <body>
    <form id="inputForm" action="Order.do">
    <input type="hidden" name="method" value="3" />
    <input type="hidden" name="id" value="<%=entity.getId()%>" />
    	<br />
		<br />
   <table width="90%" align="center" border=1 style="text-align: center;">
<tr>
<td width="10%">姓名</td>
<td width="40%"><input type="text" style="width:90%" name="name" value="<%=entity.getName()==null?"":entity.getName()%>"/></td>
<td width="10%">出发时间</td>
<td width="40%"><input type="text" style="width:90%" name="startTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<%=entity.getStartTime()==null?"":entity.getStartTime()%>"/></td>
</tr>
<tr>
<td width="10%">价格</td>
<td colspan=3><input type="text" style="width:90%" name="price" value="<%=entity.getPrice()==null?"":entity.getPrice()%>"/></td>
</tr>
<tr>
<td colspan=4>

<input style="cursor: hand; height: 27px;" type="submit"
						value=" 保 存 "/>&nbsp;&nbsp;&nbsp;&nbsp;
						
<input style="cursor: hand; height: 27px;" type="button" onclick="window.location.href='Order.do?method=0';"
						value=" 退 出 "/>						
						</td>
</tr>
</table>
    </form>
  </body>
</html>
