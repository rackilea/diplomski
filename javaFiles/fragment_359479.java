String loginURL = request.getContextPath() + "/pages/login.jspx";

if (needsToRedirect && !request.getRequestURI().equals(loginURL)) {
    response.sendRedirect(loginURL);
}
else {
    chain.doFilter(request, response);
}