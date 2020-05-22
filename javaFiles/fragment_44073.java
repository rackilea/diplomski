@Configuration static class ContextConfiguration {

     @Bean
     public static PropertySourcesPlaceholderConfigurer properties() throws Exception {
            return new PropertySourcesPlaceholderConfigurer();
     }
}