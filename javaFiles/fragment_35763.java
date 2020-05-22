public class MultiMapRequestBodyMethodArgumentResolver implements HandlerMethodArgumentResolver {

    public  boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(MultiMapRequestBody.class); // maybe check argument type too.
    }

    public  Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
        NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // Logic for validation and converting using Jackson
        // Take a look at MappingJackson2HttpMessageConverter

    }
}