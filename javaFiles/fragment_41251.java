public class CustomFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setAttribute("myObject", new Object());
        chain.doFilter(request, response);
    }
    // ... init and destroy methods
}