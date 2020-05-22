@Configuration
class AppConfig{
   @Conditional(/* some condition */)
   @Bean
   ServiceB serviceB1(){
     return new ServiceBImpl1();
   }

   @Conditional(/* some condition */)
   @Bean
   ServiceB serviceB2(){
     return new ServiceBImpl2();
   }

   // store a local reference    
   @Autowired
   private dynamicServiceB;

   @Bean
   ServiceA serviceA(){
     return new ServiceA(dynamicServiceB);
   }
}