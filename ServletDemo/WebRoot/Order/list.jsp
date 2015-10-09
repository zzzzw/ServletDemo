<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType = "text/html;charset=UTF-8"%>
<%@page import="com.ll.www.mis.entity.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
	<form id="inputForm" action="Order.do" >
	<input type="hidden" name="method" value="1" />
		<br />
		<br />
<table width="90%" align="center" border=1 style="text-align: center;">
<tr>
<td width="10%">姓名</td>
<td width="40%"><input type="text" style="width:90%" name="name" value=""/></td>
<td width="10%">价格</td>
<td width="40%"><input type="text" style="width:90%" name="price" value=""/></td>
</tr>
<tr>
<td width="10%">出发时间</td>
					<td width="40%">
						<input type="text" style="width: 90%" name="startTime"
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="" />
					</td>

				</tr>
<tr>
<td colspan=4><input style="cursor: hand; height: 27px;" type="submit"
						value=" 查 询 "/></td>
</tr>
</table>
        <br />
		<table width="90%" align="center" border=1 style="text-align: center;">
			<tr>
				<td colspan=6 align="right">
					<input style="cursor: hand; height: 27px;" type="button"
						value=" 新 增 "
						onclick="window.location.href='Order.do?method=2';" />
				</td>
			</tr>
			<tr>
				<td width="10%">
					ID
				</td>
				<td width="20%">
					姓名
				</td>
				<td width="30%">
					出发时间
				</td>
				<td width="10%">
					价格
				</td>
				 
				<td>
					操作
				</td>
			</tr>
			<%
				if (request.getAttribute("listall") != null) {
					List<Order> list = (List<Order>) request
							.getAttribute("listall");
					for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td><%=list.get(i).getId()%></td>
				<td><%=list.get(i).getName()%></td>
				<td><%=list.get(i).getStartTime()%></td>
				<td><%=list.get(i).getPrice()%></td>
				 
				<td>
					<a href="Order.do?method=2&id=<%=list.get(i).getId()%>">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="Order.do?method=4&id=<%=list.get(i).getId()%>">删除</a>
				</td>
			</tr>
			<%
				}
				}
			%>
		</table>
		<br />
		<br />
			</form>
	</body>

</html>
