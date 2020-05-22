public class UpperCaseResolver implements HandlerMethodArgumentResolver {

    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(UpperCase.class) != null;
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) throws Exception {
        UpperCase attr = parameter.getParameterAnnotation(UpperCase.class);
        return webRequest.getParameter(attr.value()).toUpperCase();
    }
}