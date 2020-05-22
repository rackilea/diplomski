@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws    
         ServletException, IOException {
    if (!resp.isCommitted()) {
        resp.sendRedirect("http://www.google.com");
    } else {
        log.info("    Response was already committed!");
    }
    return;
}