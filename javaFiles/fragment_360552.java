<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="g" %>

<c:set var = "error_human" scope = "session" value = "We cannot currently serve the page you request"/>
<c:set var = "error_tech" scope = "session" value = "Internal error"/>
<c:set var = "exception_message" scope = "session" value = "The current page refuses to load due to an internal error"/>
<g:error />