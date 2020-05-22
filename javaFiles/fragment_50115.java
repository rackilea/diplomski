@Configuration
@ComponentScan(basePackages = {"package name"})
public class WebConfig extends WebMvcConfigurerAdapter {
@Override
public void configurePathMatch(PathMatchConfigurer configurer) {
    AntPathMatcher matcher = new AntPathMatcher();
    matcher.setCaseSensitive(false);
    configurer.setPathMatcher(matcher);
  }
 }