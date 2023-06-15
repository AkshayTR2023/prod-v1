<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	    <%@ page import="com.example.demo.*"%>
<%@ page import="java.util.* "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
<style>
.menu-box {
	border: 1px solid #ccc;
	padding: 10px;
	width: 300px;
	margin: 0 auto;
	text-align: center;
}

.menu-box a {
	display: block;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<div class="menu-box">
	<h1>Edit product</h1>
	<form action="edit">
		<table>
			<tr>
				<td>Product Name</td>
				<td><input type="text" name="name" value="<%=((com.example.demo.Product) request.getAttribute("prod")).getProdName()%>"></td>
			</tr>
			<tr>
				<td>Product Cost</td>
				<td><input type="text" name="cost" value="<%=((com.example.demo.Product) request.getAttribute("prod")).getProdCost()%>"></td>
			</tr>
			<tr>
				<td>Order Date</td>
				<td><input type="date" name="dt" value="<%=((com.example.demo.Product) request.getAttribute("prod")).getOrderDate()%>"></td>
			</tr>
			<tr>
			<td></td>
			<td>
			<input type="hidden" name="id"
				value="<%=((com.example.demo.Product) request.getAttribute("prod")).getProdID()%>">
				</td>
			<tr>
				<td></td>
				<td><input type="submit" value="Edit Product"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
