protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    resp.setContentType("text/plain");
    AsyncContext context = req.startAsync();

    // Possibly in another thread:

    // Initiate call to external service.

    resp.getWriter().write("Call initiated OK.\n\n");
    resp.getWriter().flush();

    // Definitely in another thread:

    // Call to external service returns.

    resp.getWriter().write("Result: " + result);
    resp.getWriter().flush();
    context.complete();
}