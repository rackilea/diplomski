private ApplicationListener<?> applicationListener() {
        ApplicationEventListeningMessageProducer producer = new ApplicationEventListeningMessageProducer();
        producer.setEventTypes(TestApplicationEvent1.class);
        producer.setOutputChannel(resultsChannel());
        return producer;
    }

... 

 IntegrationFlows.from(applicationListener())