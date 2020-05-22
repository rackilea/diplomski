public class CheckSessionInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private CheckSessionIdHandler checkSessionIdHandler;

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
 //        ...
        return checkSessionIdHandler.checkSessionValid(request);
    }


}