public class CustomInterfaceResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(CustomInterface.class);
    }


    @Override
    public CustomInterface resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // instantiate CustomInterface impls based on request parameters
        // and return it of course
    }
}