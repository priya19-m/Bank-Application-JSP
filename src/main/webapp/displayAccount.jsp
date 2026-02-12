<%@ page import="com.wipro.bank.bean.BankBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Details</title>
</head>
<body>
<h2>Account Details</h2>
<% String message = (String)request.getAttribute("message");
BankBean bean=(BankBean)request.getAttribute("bankBean");
if(message!=null){
%>
<h3><%= message %></h3>
<%
} else if(bean!=null){
%>
Record ID: <%= bean.getRecordID() %><br><br>
Customer Name: <%= bean.getCustomerName() %><br><br>
Account Type: <%= bean.getAccountType() %><br><br>
Opening Date: <%= bean.getOpeningDate() %><br><br>
Balance: <%= bean.getBalance() %><br><br>
Contact: <%= bean.getContact() %><br><br>
Remarks: <%= bean.getRemarks() %><br><br>
<% }
%>
<br>
<a href="menu.html">Back to Menu</a>
</body>
</html>