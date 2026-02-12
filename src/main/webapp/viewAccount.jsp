<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Account</title>
</head>
<body>
<h2>View Account</h2>
<form action="MainServlet" method="post">

<input type="hidden" name="operation" value="viewRecord">
Customer Name:
<input type="text" name="customerName" required> <br> <br>
Opening Date:
<input type="date" name="openingDate" required> <br> <br>

<input type="submit" value="ViewRecord">
</form>
</body>
</html>