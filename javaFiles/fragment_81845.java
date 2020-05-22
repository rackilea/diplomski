public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        if (isConnectionBroken(DaemonConnector.connectionStatus)) {
            //set error 500 because daemon connection lost
            response.sendError(500, "Connection to Daemon failed: " + DaemonConnector.connectionStatus);
        } else {
            // everything works fine, just continue in the filter chain
            chain.doFilter(req, res);
        }
    }