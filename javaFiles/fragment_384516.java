@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }
}