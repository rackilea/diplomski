@Singleton
public class UserAuthHeaderParamValueFactoryProvider extends AbstractValueFactoryProvider {

    @Inject
    protected UserAuthHeaderParamValueFactoryProvider(MultivaluedParameterExtractorProvider mpep, ServiceLocator locator) {
        super(mpep, locator, Parameter.Source.UNKNOWN);
    }

    @Override
    protected Factory<?> createValueFactory(Parameter parameter) {
        Class<?> classType = parameter.getRawType();

        if (classType == null || (!classType.equals(String.class))) {
            return null;
        }

        return new AbstractHttpContextValueFactory<String>() {
            @Override
            protected String get(HttpContext httpContext) {
                // you can get the header value here
                return "testString";
            }
        };
    }
}