@Configuration
    @EnableWebMvc
    public class Config extends WebMvcConfigurerAdapter {
    ...
      @Override
      public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
          argumentResolvers.add(new UpperCaseResolver());
      }
    ...
    }