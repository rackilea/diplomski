boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
if (ajax) {
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    response.getWriter().write(responseToClient);
    response.getWriter().flush();
    response.getWriter().close();
} else {
    response.sendRedirect(request.getContextPath() + "/error");
}