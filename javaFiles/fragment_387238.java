<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="testingThings.EL.linkedlist.BankAccount"%>
<%@ page import="java.util.LinkedList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
        LinkedList<BankAccount> accounts = new LinkedList<BankAccount>();
        accounts.add(new BankAccount("acc1", 1000.00));
        accounts.add(new BankAccount("acc2", 2000.00));

        pageContext.setAttribute("accounts", accounts);
    %>
    <c:forEach items="${accounts}" var="acct">
        <p>${acct.accountName}</p>
        <br />
        <p>${acct.accountBalance}</p>
        <br />
    </c:forEach>
</body>
</html>