public final class XssFilter implements Filter {

public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
  throws IOException, ServletException
{
    //check request...
    if (ok) {
       chain.doFilter(request, response);
    } else {
       // do something with the response
    }
}