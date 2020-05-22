Enumeration headers = req.getHeaderNames();
while (headers.hasMoreElements()) {
    String name = (String)headers.nextElement();
    String value = req.getHeader(name);
    resp.getWriter().println(String.format("%s: %s", name, value));
}