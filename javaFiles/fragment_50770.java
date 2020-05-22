public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
        String path = ((HttpServletRequest) request).getServletPath();
        String newPath = null;

                newPath = "f" + path;
            }

        } else {
            newPath = path;
        }
        request.getRequestDispatcher(newPath).forward(request, response);
        return;
    }
    chain.doFilter(request, response);
}