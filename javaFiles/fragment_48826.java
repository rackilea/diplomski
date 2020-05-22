HttpServletRequest request = (HttpServletRequest) req;
HttpServletResponse response = (HttpServletResponse) res;

String ctx = request.getContextPath();
String uri = request.getRequestURI();
String viewId = uri.substring(ctx.length(), uri.length());

if (viewId.startsWith("/xhtml")) {
    // Redirect to URL without /xhtml (changes URL in browser address bar).
    response.setStatus(301);
    response.setHeader("Location", ctx + viewId.substring("/xhtml".length());
    // Don't use response.sendRedirect() as it does a temporary redirect (302).
} else {
    // Forward to the real location (doesn't change URL in browser address bar).
    request.getRequestDispatcher("/xhtml" + viewId).forward(request, response);
}