<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.demo.*"%>
<%@ page import="java.util.* "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
<style>
    table {
        width: 100%;
        border-collapse: collapse;
    }
    th, td {
        padding: 8px;
        border: 1px solid #ccc;
    }
    th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
<a href="index.jsp"><center><button>Home</button></center></a><br>
	<%
	List<Product> product = (List<Product>) request.getAttribute("list");
	%>
	<table>
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Cost</th>
			<th>Order Date</th>
			<th>Edit Product</th>
			<th>Delete Product</th>
		</tr>
		<%
		for (Product prod : product) {
		%>

		<tr>
			<td><%=prod.getProdID()%></td>
			<td><%=prod.getProdName()%></td>
			<td><%=prod.getProdCost()%></td>
			<td><%=prod.getOrderDate()%></td>
			<td><a href="getforedit?id=<%=prod.getProdID()%>">Edit Product</a></td>
			<td><a href="delete?id=<%=prod.getProdID()%>">Delete Product</a></td>
			<td></td>
		</tr>

		<%
		}
		%>
	</table>
</body>
</html>