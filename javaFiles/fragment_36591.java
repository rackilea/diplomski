@Configuration
public static class TestContext{
        @Bean
        public static PropertySourcesPlaceholderConfigurer properties(){
          return new PropertySourcesPlaceholderConfigurer();
        }
}