@Component
public class CustomAuthenticationHandler extends SimpleUrlAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        setUseForward(true);
        saveException(request, exception);
        if (exception.getClass().equals(CredentialsExpiredException.class)){
            setDefaultFailureUrl("/changePassword");                  
        } else {
            setDefaultFailureUrl("/login?error");
        }
        super.onAuthenticationFailure(request, response, exception);
    }

}