try {
    chain.doFilter(request, response);
}
catch (ServletException e) {
    if (e.getRootCause() instanceof IllegalArgumentException) {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
    else {
        throw e;
    }
}