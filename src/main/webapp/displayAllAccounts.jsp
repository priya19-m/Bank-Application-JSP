<%@ page import="java.util.List" %>
<%@ page import="com.wipro.bank.bean.BankBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Accounts</title>
</head>
<body>
<h2>All Account Records</h2>
<%
String message = (String) request.getAttribute("message");
List<BankBean> list = (List<BankBean>) request.getAttribute("accountList");
if (message != null) {
%>
<h3><%= message %></h3>
<%
} else if (list != null && !list.isEmpty()) {
for (BankBean bean : list) {
%>
<hr>
Record ID: <%= bean.getRecordID() %><br>
Customer Name: <%= bean.getCustomerName() %><br>
Account Type: <%= bean.getAccountType() %><br>
Opening Date: <%= bean.getOpeningDate() %><br>
Balance: <%= bean.getBalance() %><br>
Contact: <%= bean.getContact() %><br>
Remarks: <%= bean.getRemarks() %><br>
<%
}
}
%>
<br>
<a href="menu.html">Back to Menu</a>
</body>
</html>