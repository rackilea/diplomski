@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String unm = req.getParameter("unm");
    String psw = req.getParameter("psw");

    PrintWriter out = resp.getWriter();

    if (unm.equals("someusername") && ps.equals("hello123")) {
        out.println("Welcome " + unm);
    } else {
        out.println("invalid entry");
    }
    out.close();
}