@WebFilter(urlPatterns={"/some/*"})
public class SomeFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        // Do here your application startup job.

        // If you have any <init-param> in web.xml, then you could get them
        // here by config.getInitParameter("name") and assign it as field.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Do here your request/response preprocessing job.

        // Continue the request/response (if you haven't already forwarded/redirected the request/response beforehand).
        chain.doFilter(request, response);

        // Do here your request/response postprocessing job.
    }

    @Override
    public void destroy() {
        // Do here your application shutdown job.

        // If you have assigned any expensive resources as field of
        // this Filter class, then you could clean/close them here.
    }

}