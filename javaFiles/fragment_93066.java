<%
            if(rs.getString("password").equals(pwd))
           {
               response.sendRedirect("homepage.jsp");  
            }else
                {
        %>
        <script language="JavaScript">
            alert("Incorrect Login Details");
        </script>
        <%
        }

        %>