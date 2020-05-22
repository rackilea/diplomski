@Provider
@Component
public class AppConfigFilter implements ContainerRequestFilter {
    @Value("${some.prop.key}")
    private String aValue;
    // class implementation
}