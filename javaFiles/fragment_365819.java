public void doFilter(ServletRequest request, 
    ServletResponse response, FilterChain chain) throws
    IOException, ServletException {
    String encoding = selectEncoding(request);
    if (encoding != null){
       //request.setCharacterEncoding(encoding);
       response.setCharacterEncoding(encoding);
       //response.setContentType(contentType);
    }
    chain.doFilter(request, response);
 }
 public void init(FilterConfig filterConfig) throws
    ServletException {
    this.filterConfig = filterConfig;
    this.encoding = filterConfig.getInitParameter("encoding");
 }
 protected String selectEncoding(ServletRequest request) {
    return (this.encoding);
 }