@Configuration
public class MyBeansConfiguration {

   @Bean
   public MyTestClass getMyTestClass(MyService myService) {
       return new MyTestClass(myService);
   }
}