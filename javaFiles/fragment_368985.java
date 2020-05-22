public class Logout extends SimpleUrlLogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        if (authentication != null) {
            // do something 
        }

        setDefaultTargetUrl("/login");
        super.onLogoutSuccess(request, response, authentication);       
    }
}