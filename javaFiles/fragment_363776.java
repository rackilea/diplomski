@Component("authenticationFailureHandler")
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

@Override
public void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException exception) throws IOException, ServletException, MyException {
    if (exception instanceof DisabledException) {
        request.getRequestDispatcher("/notconfirmed")
                    .forward(request, response);
    } else {
        super.onAuthenticationFailure(request, response, exception);
    }    
}