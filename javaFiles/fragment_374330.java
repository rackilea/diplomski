@Configuration
public MyConfig extends WebMvcConfigurationSupport {

    @Bean
    public PathMatcher pathMatcher() {
      // Your AntPathMatcher here.
    }

    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping  rmhm = super.requestMappingHandlerMapping();
        rmhm.setPathMatcher(pathMatcher());
        return rmhm;
    }
}