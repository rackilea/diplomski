@Override
protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
        Authentication authResult) throws IOException, ServletException {
    SecurityContextHolder.getContext().setAuthentication(authResult);

    chain.doFilter(request, response);
}

@Override
protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException failed) throws IOException, ServletException {
    logger.debug("failed authentication while attempting to access "
            + urlPathHelper.getPathWithinApplication((HttpServletRequest) request));

    //Add more descriptive message
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
            "Authentication Failed");
}