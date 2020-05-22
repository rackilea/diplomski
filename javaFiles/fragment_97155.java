public class AuthenticationCheckInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //Check if user exists in session. 
        //If no, redirect to login page using response.sendRedirect() and return false
        //If yes, return true
    }
}