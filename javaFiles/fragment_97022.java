public void doFilter(ServletRequest request,  ServletResponse response, FilterChain chain) throws IOException, ServletException {
    long start = System.currentTimeMillis();   
    chain.doFilter(request, response);
    long elapsedTime = System.currentTimeMillis() - start;
    System.out.println("Method execution time: " + elapsedTime + " milliseconds.");
}