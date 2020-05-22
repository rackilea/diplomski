@Bean
  public IntegrationFlow syncFlow() {
        // ... the same as above ...
        .transform(/* map REST to SOAP */)
        .channel(c -> c.executor(Executors.newCachedThreadPool()))  // see (1)
        .handle(/* send a message with SOAP client */)
        .get();
  }