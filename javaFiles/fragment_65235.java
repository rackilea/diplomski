@Configuration
 @ComponentScan(basePackages = {"a.package.containing.the.service"              
  "some.other.class.package"})
 public class AppConfiguration {

  //By the way you can also define beans like:
   @Bean 
   public AwesomeService service() {
       return new AwesomeService();
   }

 }