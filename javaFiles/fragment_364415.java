@SpringBootApplication
public class TheApplication extends WebMvcConfigurerAdapter {

  public static void main(String[] args) {
    SpringApplication.run(PageServiceApplication.class, args);
  }

  @Bean
  public Converter<List<String>, String> converter() {
    return new Converter<List<String>, String>() {
      public String convert(List<String> source) {
        return new JSONArray(source).toString();
      }
    };
  }
}