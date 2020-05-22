public class YourFilter implements Filter {
    public void init(FilterConfig filterConfig)  throws ServletException { }
    public void destroy() { }

    public void doFilter(ServletRequest request, ServletResponse response, 
        FilterChain chain) throws IOException, ServletException {
        // whatever you want to do before doPost
        chain.doFilter(request, wrapper);
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if(httpRequest.getMethod().equalsIgnoreCase("POST")) {
            //whatever you want to do after doPost only HERE
        }
        //whatever you want to do after doGet, doPost, doPut and others HERE
    }
}