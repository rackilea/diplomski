<jsp:scriptlet>
    String param1 = request.getParameter("p1");
    String param2 = request.getParameter("p2");

    HttpSession session1 = request.getSession(true);
    session1.setAttribute("p1", param1);
    session1.setAttribute("p2", param2);
    response.sendRedirect("intermediateTarget.jsp");
</jsp:scriptlet>