@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/plain");
        resp.getWriter().println("Hello, world");

        resp.sendRedirect("abc.jsp");
// you can replace it with RequestDispatcher also
    }