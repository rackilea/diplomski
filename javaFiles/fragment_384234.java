<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="conta.Contagenere" %>

<%-- Faccio avanzare i counter --%>
<jsp:useBean id="lcontagenere" class="conta.Contagenere" scope="application"></jsp:useBean>
<% 
if(request.getParameter("uomo").compareTo("Maschio") == 0)
{
%>
    <jsp:setProperty property="uomo" name="lcontagenere" value="1"/>

<%}
else{
%>
    <jsp:setProperty property="donna" name="lcontagenere" value="1"/>

<% }%>
<%-- Creazione dinamica della pagina --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Benvenuto...</title>
    </head>
        <body>
            <h1>
<%= 
request.getParameter("nome") + ", sei " + 
((request.getParameter("uomo").compareTo("Maschio") == 0) ? "l'uomo n." : "la donna n.")
%>

<%
if(request.getParameter("uomo").compareTo("Maschio") == 0)
{ %>
<jsp:getProperty property="uomo" name="lcontagenere"/>
<% }
else
{ %>
<jsp:getProperty property="donna" name="lcontagenere"/>
<% } %>
che si registra a questa applicazione! 
<br>
Verrai rediretto su un altra pagina ...

            </h1>
        </body>
</html>