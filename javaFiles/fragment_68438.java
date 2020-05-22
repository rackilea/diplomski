public class CustomFilter implements Filter 
{

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException 
    {
        CustomWrapper wrapper = new CustomWrapper((HttpServletRequest) request);
        chain.doFilter(wrapper, response);

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

   }