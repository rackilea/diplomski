public class CustomInterceptor extends HandlerInterceptorAdapter /* which implements HandlerInterceptor */ {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("myObject", new Object());
        // add as many as you wish                
    }

}