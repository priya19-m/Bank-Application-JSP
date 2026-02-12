<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Account</title>
</head>
<body>
<h2>Add Account Record</h2>
<form action="MainServlet" method="post">
<input type="hidden" name="operation" value="newRecord">
Customer Name:
<input type="text" name="customerName" required> <br> <br>
Account Type:
<input type="text" name="accountType" required> <br> <br>
Opening Date:
<input type="date" name="openingDate" required> <br> <br>
Balance:
<input type="number" name="balance" required> <br> <br>
Contact:
<input type="text" name="contact" required> <br> <br>
Remarks:
<input type="text" name="remarks" required> <br> <br>
<input type="submit" value="Add Record">
</form>
</body>
</html>