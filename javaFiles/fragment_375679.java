public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

    RequestDispatcher requestDispatcher = req.getRequestDispatcher("myJsp.jsp");

    try {
        requestDispatcher.forward(req, res);
    }
    catch (ServletException e) {
        logger.error("Exception occurred:", e);
    }
    catch (IOException e) {
        logger.error("Exception occurred:", e);
    }
}