public class UsernameHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(Username.class);
    }
    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        String username = nativeWebRequest.getParameter("username");
        if (username == null && nativeWebRequest.getUserPrincipal() != null) {
            username = nativeWebRequest.getUserPrincipal().getName();
        }
        return new Username(username);
    }
}