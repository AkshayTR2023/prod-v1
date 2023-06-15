<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
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
	<h1>Add new product</h1>
	<form action="add">
		<table>
			<tr>
				<td>Product Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Product Cost</td>
				<td><input type="text" name="cost"></td>
			</tr>
			<tr>
				<td>Order Date</td>
				<td><input type="date" name="dt"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add Product"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>