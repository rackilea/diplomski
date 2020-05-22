public class ExceptionFilter implements Filter {
    private ServletContext servletContext;

    public void destroy() {}
    public void doFilter(ServletRequest req, 
                         ServletResponse resp, 
                         FilterChain chain) 
      throws IOException, ServletException {        
        String mapping = getMappingFor((HttpServletRequest)req);
        if(mapping!=null) servletContext.getRequestDispatcher(mapping).forward(req,resp);
        else chain.doFilter(req, resp);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
       this.servletContext = filterConfig.getServletContext();
    }

    private String getMappingFor(HttpServletRequest req) {...}