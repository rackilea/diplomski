public class MessageResolverTest implements HandlerMethodArgumentResolver {

    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(<Interface>.class);
    }

    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {

        String name = ModelFactory.getNameForParameter(methodParameter);
        WebDataBinder webDataBinder = webDataBinderFactory.createBinder(nativeWebRequest, new <ConcreteBean>(), name);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues(nativeWebRequest.getParameterMap());
        webDataBinder.bind(mutablePropertyValues);

        return webDataBinder.getBindingResult().getTarget();
    }
}