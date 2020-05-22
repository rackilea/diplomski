protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    Parts parts = null
    try {
        parts = request.getParts();
    } catch (IllegalStateException e) {
        // File or request is too big!
        // Here you can send back an error message to the client,
        // I just send back an HTTP 400 (Bad Request) error page.
        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        return;
    }

    // Process parts...
}