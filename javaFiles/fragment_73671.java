@Provider
public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return new AntPathMatcher().match("/api/v1/menus", request.getServletPath());
    }

}