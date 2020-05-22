<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="g" %>

<c:set var = "error_human" scope = "session" value = "We cannot find the page you are looking for"/>
<c:set var = "error_tech" scope = "session" value = "Page not found"/>
<c:set var = "exception_message" scope = "session" value = "The current page cannot be found"/>
<g:error />