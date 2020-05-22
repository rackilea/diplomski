@WebFilter(urlPatterns = {"*.pdf"})
public class PdfFilter implements Filter {

    @Override 
    public void doFilter(ServletRequest request, ServletResponse response,
                     FilterChain chain) throws IOException, ServletException {

         HttpServletResponse httpServletResponse = (HttpServletResponse)response;
         httpServletResponse.addHeader("X-Robots-Tag", ""noindex, nofollow");

         chain.doFilter(request, response);
    }

}