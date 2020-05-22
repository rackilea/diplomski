@Override
public boolean supportsParameter(final MethodParameter parameter) {
    return parameter.hasParameterAnnotation(YourCustomAnnotation.class);
}

@Override
public Object resolveArgument(final MethodParameter parameter, final ModelAndViewContainer mavContainer,
                              final NativeWebRequest webRequest, final WebDataBinderFactory binderFactory) throws Exception {
    return ...; // a List
}