public class HttpMethodFilter implements Filter
{
   public void init(FilterConfig filterConfig) throws ServletException
   {

   }

   public void doFilter(ServletRequest request, ServletResponse response,
       FilterChain filterChain) throws IOException, ServletException
   {
       HttpServletRequest httpRequest = (HttpServletRequest) request;        
       if(httpRequest.getMethod().equalsIgnoreCase("POST")){

       }
       filterChain.doFilter(request, response);
   }

   public void destroy()
   {

   }
}