...
 .handle(myEnricher())
 ...

 @Bean
 public void MessageHandler myEnricher() {
    return new FileHeaderNamingEnricher();
 }