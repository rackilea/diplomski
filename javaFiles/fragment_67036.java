public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {
    resp.setContentType("text/html; charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("Hello, world!!@!");
    out.println("我是人");  //some chinese character
    out.println(resp.getCharacterEncoding());
    out.flush();
    out.close();
}