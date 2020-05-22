try {
    chain.doFilter(request, response);
}
catch (IOException e) {
    if (!e.getClass().getSimpleName().equals("ClientAbortException")) {
        throw e;
    }
}