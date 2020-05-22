for (Entry<String, HttpServlet> entry : servlets.entrySet()) {
    String urlPattern = entry.getKey();
    HttpServlet servlet = entry.getValue();
    if (request.getRequestURL().matches(urlPattern)) {
        servlet.service(request, response);
        break;
    }
}