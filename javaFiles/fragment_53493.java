@Configuration
@ComponentScan("com....package.of.bean2")
public class SpringConfig {
   @Bean 
   public someBean() {
      return new Bean1();
   }
}