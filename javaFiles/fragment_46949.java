@Configuration
class MyConfig {

  @Bean
  public MyCustomBdrpp myBdrpp(@Autowired ApplicationContext context) {
    return new MyCustomBdrpp(context);
  }

}