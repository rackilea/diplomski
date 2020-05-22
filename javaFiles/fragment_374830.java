public class FooParamResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return Foo.class.isAssignableFrom(parameter.getParameterType())
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        // this is the place where you handle the query params
        // and add them to your Foo instance
        HttpServletRequest request = (HttpServletRequest) nativeWebRequest.getNativeRequest();

        // this is your part ;) 
        String field = // call method to determine field value...
        Boolean asc = // call method to determine asc value
        Foo foo = new Foo();
        foo.setField(field);
        foo.setAsc(asc);
        return foo;
    }
}