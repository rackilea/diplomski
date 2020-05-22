if("student".equals(usertype)){
    response.sendRedirect("studenthome.jsp");
}
else if("faculty".equals(usertype)){
    response.sendRedirect("facultyhome.jsp");
}