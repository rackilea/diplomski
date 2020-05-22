<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<form action="index.jsp">
    <body>
        First INPUT:
        <input name="firstinput" type="text" name="fname">
        <br>
        <input type="submit" value="Submit">
        <%
           String first = request.getParameter("firstinput");
           if(first!=null){

              String data=null;
              if(first.startsWith("\"") && first.endsWith("\"")){
                data = first.substring(1, first.length-1)
              }
              out.println(data );
         }

        %>
    </body>
</form>
</html>