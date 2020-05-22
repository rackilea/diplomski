@ConditionalOnMissingBean
 @Bean
 public MessageListener useThisOneWhenTheOtherIsMissing() {
     // this bean will be used when the other one is not available
     // ...
 }