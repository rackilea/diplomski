public class WrongAcceptHeaderInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        if (!"application/json".equals(request.getHeader("Accept"))) {
            //you can change or omit the message 
            response.sendError(SC_UNSUPPORTED_MEDIA_TYPE, "Your error message"); 
            // return false to skip further processing
            return false;
        }
    }
}