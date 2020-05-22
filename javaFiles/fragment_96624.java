public class UserToMdcFilter implements javax.servlet.Filter
{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        MDC.put("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        try {
            chain.doFilter(request, response);
        } finally {
            MDC.remove("user");
        }
    }

    //...
}