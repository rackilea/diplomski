@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    ...

    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping mapping = super.requestMappingHandlerMapping();
        mapping.setPathMatcher(pathMatcher()); // some PathMatcher bean
        return mapping;
    }

    ...
}