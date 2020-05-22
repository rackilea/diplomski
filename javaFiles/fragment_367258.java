if (userHasPermission) {
    chain.doFilter(request, response);
} else {
    String referrer = ((HttpServletRequest) request).getHeader("referer");
    ((HttpServletResponse) response).sendRedirect(referrer);
}