public class PreAuthorizeChecker implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            PreAuthorize annotation = AnnotationUtils.findAnnotation(hm.getMethod(), PreAuthorize.class);
            if (annotation == null) {
                // prevent access to method wihout security restrictions
                throw new RuntimeException("Rights are not defined for this handler");
            }

        }
        return true;
    }
.....
}