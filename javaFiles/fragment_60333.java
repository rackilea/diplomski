@SpringBootApplication
    public class SpringBootTomcatApplication extends SpringBootServletInitializer {
      public static void main(String[] args) {
        SpringApplication.run(SpringBootTomcatApplication.class, args);
      }

      @Override
      protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootTomcatApplication.class);
      }
    }