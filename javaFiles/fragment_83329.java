public class SwitchingFilter extends GenericFilterBean {

    private Filter[] filters = // ...

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        filters[i].doFilter(request, response, chain);
        // do filterChain.doFilter(request, response); ??
   }
}