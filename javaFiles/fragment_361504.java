public class TicketAndLDAPAuthenticationFilter  extends AbstractAuthenticationProcessingFilter {

    public TicketAndLDAPAuthenticationFilter(String defaultProcessUrl) {
        super(new AntPathRequestMatcher(defaultProcessUrl, "POST"));
    }

    public TicketAndLDAPAuthenticationFilter(String defaultProcessUrl, AuthenticationSuccessHandler authenticationSuccessHandler, AuthenticationFailureHandler authenticationFailureHandler) {
        super(new AntPathRequestMatcher(defaultProcessUrl, "POST"));
        setAuthenticationFailureHandler(authenticationFailureHandler);
        setAuthenticationSuccessHandler(authenticationSuccessHandler);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //Save the password for later
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ( username==null || password==null) {
            return null;
        }

        TicketAndLDAPAuthenticationToken token = new TicketAndLDAPAuthenticationToken(username,password,null);

        return token;
    }
}