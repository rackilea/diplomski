public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private IUserSession UserSession;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("interceptor called for " + request.getRequestURI());
        if(UserSession.isSessionValid()){
            System.out.println("ready to enter");
            return true;
        }else{
            System.out.println("not logged in...redirecting to login");
            response.sendRedirect("/in_development_page");
            return false;
        }
    }
}