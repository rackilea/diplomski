@Bean
    public IntegrationFlow jmsMessageDrivenRedeliveryFlow() {
        return IntegrationFlows
                .from(Jms.messageDrivenChannelAdapter(this.jmsConnectionFactory)
                        .errorChannel(IntegrationContextUtils.ERROR_CHANNEL_BEAN_NAME)
                        .destination("jmsMessageDriverRedelivery"))
                .<String, String>transform(p -> {
                    throw new RuntimeException("intentional");
                })
                .get();
    }

    @Bean
    public CountDownLatch redeliveryLatch() {
        return new CountDownLatch(3);
    }

    @Bean
    public IntegrationFlow errorHandlingFlow() {
        return IntegrationFlows.from(IntegrationContextUtils.ERROR_CHANNEL_BEAN_NAME)
                .handle(m -> {
                    MessagingException exception = (MessagingException) m.getPayload();
                    redeliveryLatch().countDown();
                    throw exception;
                })
                .get();
    }