@Configuration
public class ServletConfig extends WebMvcConfigurerAdapter {
  @Override
  public void configurePathMatch(final PathMatchConfigurer configurer) {
    configurer.setUseSuffixPatternMatch(false);
    configurer.setUseTrailingSlashMatch(false);
  }
}