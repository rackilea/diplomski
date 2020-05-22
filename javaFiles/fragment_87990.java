<%
    int totalEmployee = 0;
    if (rs != null && rs.next()) {
         totalEmployee = rs.getInt("totalEmployee");
    }
%>