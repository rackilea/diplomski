@Bean
    public MessageHandler logger() {
        LoggingHandler loggingHandler = new LoggingHandler("INFO");
        loggingHandler.setLoggerName("logger");
        // This is redundant because the default expression is exactly "payload"
        // loggingHandler.setExpression("payload");
        return loggingHandler;
    }

    @Bean
    public MessageHandler httpGateway(@Value("${api.base.uri}/data") URI uri) {
        HttpRequestExecutingMessageHandler httpHandler = new HttpRequestExecutingMessageHandler(uri);
        httpHandler.setExpectedResponseType(String.class);
        httpHandler.setHttpMethod(HttpMethod.PUT);
        return httpHandler;
    }

    @Bean
    public IntegrationFlow httpFlow(MessageHandler httpGateway) {
        return IntegrationFlows.from("requestChannel")
                .handle(httpGateway)
                .handle(logger())
                .get();
    }