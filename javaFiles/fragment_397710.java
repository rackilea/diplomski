@Bean
    public SimpleMappingExceptionResolver exceptionResolver() {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        Properties exceptionMappings = new Properties();
        exceptionMappings.put(
                "com.test.commons.model.exceptions.NotFound", "error/404");
        exceptionMappings.put("java.lang.Exception", "error/error");
        exceptionMappings.put("java.lang.RuntimeException", "error/error");
        exceptionResolver.setExceptionMappings(exceptionMappings);
        Properties statusCodes = new Properties();
        statusCodes.put("error/404", "404");
        statusCodes.put("error/error", "500");
        exceptionResolver.setStatusCodes(statusCodes);
        // ADDED TO IGNORE THRE USER_REDIRECT_REQUIRED_EXCEPTION
        exceptionResolver
                .setExcludedExceptions(UserRedirectRequiredException.class);
        return exceptionResolver;
    }