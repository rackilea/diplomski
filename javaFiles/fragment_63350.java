public static String getUrl(HttpServletRequest req) {
    String scheme = req.getScheme();             // http
    String serverName = req.getServerName();     // hostname.com
    int serverPort = req.getServerPort();        // 80
    String contextPath = req.getContextPath();   // /mywebapp
    String servletPath = req.getServletPath();   // /servlet/MyServlet
    String pathInfo = req.getPathInfo();         // /a/b;c=123
    String queryString = req.getQueryString();          // d=789

    // Reconstruct original requesting URL
    String url = scheme+"://"+serverName+":"+serverPort+contextPath+servletPath;
    if (pathInfo != null) {
        url += pathInfo;
    }
    if (queryString != null) {
        url += "?"+queryString;
    }
    return url;
}