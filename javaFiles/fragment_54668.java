protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String url = "http://google.com";
    try {
        new URL(url).openStream(); // Will throw UnknownHostException or FileNotFoundException
        response.sendRedirect(url);
    } catch (IOException e) {
        throw new ServletException("URL " + url + " does not exist", e); // Handle whatever you want. Forward to JSP?
    }
}