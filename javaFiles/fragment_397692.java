protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    System.out.println("inside servlet 2");
    String XPID = request.getParameter("exampleXPID");
    String password = request.getParameter("exampleInputPassword1");

    PrintWriter out = response.getWriter();
    out.println("<html><body><script>alert("+XPID+")</script></body></html>");
}