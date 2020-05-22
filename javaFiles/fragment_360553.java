<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="g" %>

<c:set var = "error_human" scope = "session" value = "We cannot serve the current page"/>
<c:set var = "error_tech" scope = "session" value = "General error"/>
<c:set var = "exception_message" scope = "session" value = "A generic error prevents from serving the page"/>
<g:error />