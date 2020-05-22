private static final byte[] GIF = {
    71, 73, 70, 56, 57, 97, 1, 0, 1, 0, -16, 0, 0, 0, 0, 0, 0, 0, 0, 33, -7,
    4, 1, 0, 0, 0, 0, 44, 0, 0, 0, 0, 1, 0, 1, 0, 0, 2, 2, 68, 1, 0, 59
};

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Gather JS-collected parameters.
    String requestURI = request.getParameter("requestURI");
    String referrer = request.getParameter("referrer");
    String resolution = request.getParameter("resolution");
    String colorDepth = request.getParameter("colorDepth");
    // ...

    // Gather server-collected parameters.
    String remoteAddr = request.getRemoteAddr();
    String userAgent = request.getHeader("user-agent");
    // ...

    // Send 1x1 transparent gif (and disable browser caching on it!)
    response.setHeader("Content-Type", "image/gif");
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    response.getOutputStream().write(GIF);
}