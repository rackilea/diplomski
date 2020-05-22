public class SomeLogicInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, 
                             HttpServletResponse response, 
                             Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            SomeAnnotation someAnnotation = handlerMethod.getMethodAnnotation(SomeAnnotation.class);
            if (someAnnotation != null) {
                // Put your logic here
            }
        }

        return true; // return false if you want to abort the execution chain
    }
}