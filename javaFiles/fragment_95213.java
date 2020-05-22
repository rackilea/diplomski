@Configuration
 public class MySpringConfiguration {

      @Bean
      public UtilClass utilClass() {
          return UtilClass.INSTANCE();
      }
 }