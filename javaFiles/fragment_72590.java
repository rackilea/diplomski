public void doGet(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException  {

     String id = req.getParameter("realname");
     String password = req.getParameter("mypassword");
}

public void doPost(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException {

    String id = req.getParameter("realname");
    String password = req.getParameter("mypassword");
}