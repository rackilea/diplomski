public final void invoke(Request request, Response response) throws IOException, ServletException {

    // Disallow any direct access to resources under WEB-INF or META-INF
    MessageBytes requestPathMB = request.getRequestPathMB();
    if ((requestPathMB.startsWithIgnoreCase("/META-INF/", 0))
            || (requestPathMB.equalsIgnoreCase("/META-INF"))
            || (requestPathMB.startsWithIgnoreCase("/WEB-INF/", 0))
            || (requestPathMB.equalsIgnoreCase("/WEB-INF"))) {
            notFound(response);   // <-- Issues a response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
    }
    ...
}