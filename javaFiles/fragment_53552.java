@Bean
  public IntegrationFlow syncFlow() {
    return IntegrationFlows
        .from(/* get a REST message from microservice */)
        // here the DirectChannel is used by default 
        .filter(/* validate (and filter out) incorrect messages */)
        // here the DirectChannel is used by default too
        .transform(/* map REST to SOAP */)
        // guess what would be here?
        .handle(/* send a message with SOAP client */)
        .get();
  }