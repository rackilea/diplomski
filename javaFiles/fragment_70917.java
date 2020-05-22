MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                        .setHandlerExceptionResolvers(withExceptionControllerAdvice())
                        .build();

private ExceptionHandlerExceptionResolver withExceptionControllerAdvice() {
    final ExceptionHandlerExceptionResolver exceptionResolver = new ExceptionHandlerExceptionResolver() {
        @Override
        protected ServletInvocableHandlerMethod getExceptionHandlerMethod(final HandlerMethod handlerMethod, final Exception exception) {
            Method method = new ExceptionHandlerMethodResolver(TestAdvice.class).resolveMethod(exception);
            if (method != null) {
                return new ServletInvocableHandlerMethod(new TestAdvice(), method);
            }
            return super.getExceptionHandlerMethod(handlerMethod, exception);
        }
    };
    exceptionResolver.afterPropertiesSet();
    return exceptionResolver;
}