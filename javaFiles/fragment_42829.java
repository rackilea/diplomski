public static void top(String col1, String col2, String col3, HttpServletResponse response)
{
    PrintWriter writer = response.getWriter();
    writer.println("<tr><td>" + col1 + "</td><td>" + col2 + "</td><td>" + col3 + "</td></tr>");
    response.flushBuffer();
}