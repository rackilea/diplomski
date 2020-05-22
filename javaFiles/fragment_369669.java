try {
    chain.doFilter(request, response);
}
catch (ClientAbortException e) {
    // Ignore.
}