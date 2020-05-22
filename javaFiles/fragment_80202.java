<%
    String token = request.getParameter("a");

    // Connection to DB executing this query :
    // "UPDATE users SET active = true WHERE S_id = " + token
%>