@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    // turn off all suffix pattern matching
    configurer.setUseSuffixPatternMatch(false);
    // OR
    // turn on suffix pattern matching ONLY for suffixes
    // you explicitly register using
    // configureContentNegotiation(...)
    configurer.setUseRegisteredSuffixPatternMatch(true);
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.favorPathExtension(false);
  }
}