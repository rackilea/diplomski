@Configuration
public YourConfigClass {

    ...

    @Bean
    public HandlerMethodArgumentResolver eDataArgumentResolver() {
        return new HandlerMethodArgumentResolver() {
            @Override
            public boolean supportsParameter(MethodParameter parameter) {
                parameter.getParameterType().equals(EData.class);
            }

            @Override
            public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
                WebDataBinderFactory binderFactory) throws Exception {
                HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

                [...]

                return eData;
            }
        };
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(final HandlerMethodArgumentResolver eDataArgumentResolver) {
        final RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        requestMappingHandlerAdapter.setCustomArgumentResolvers(Collections.singletonList(eDataArgumentResolver));
        return requestMappingHandlerAdapter;
    }
}