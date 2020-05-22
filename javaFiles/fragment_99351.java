if (request.getSession().getAttribute("user") == null) {
    // Not logged in. Redirect to login page.
    response.sendRedirect("login.jsp");
} else {
    // Logged in. Just continue request.
    chain.doFilter(request, response);
}