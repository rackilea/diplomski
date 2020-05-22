if(rs.next()) {
    username = rs.getString(2);
    password = rs.getString(3);
    response.sendRedirect("Welcome.jsp");
} else {
    response.sendRedirect("Fail.jsp");
}