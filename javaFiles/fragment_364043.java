...
    void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter from FirstFilter");
        String[] cba = {"1", "2", "3", "5"};
        request.setAttribute("cba", cba);
        filterChain.doFilter(request, response);
    }
...