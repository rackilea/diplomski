@Component
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
    ) throws ServletException, IOException
    {
        HttpServletResponseCopier responseWrapper = new HttpServletResponseCopier(response);
        filterChain.doFilter(request, responseWrapper);

        System.out.println("response body: "+responseWrapper.getContent());

    }
}