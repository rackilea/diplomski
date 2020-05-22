<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<title>Welcome to web</title>
</head>
<body>
    <div class="wrapper">
        <div class="main">
            <div class="header"></div>
            <div class="content">
                <div class="content-left">
                    <jsp:include page="<%=helper.AppHelper.getPage() %>"></jsp:include>
                </div>
                <div class="content-right"></div>
            </div>
            <div class="footer"></div>
        </div>
    </div>
</body>
</html>