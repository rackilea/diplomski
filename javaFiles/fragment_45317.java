public class RestApplication extends ResourceConfig {

    private static final Logger logger = Logger.getLogger(RestApplication.class.getName());

    public RestApplication() {
        // Set this property so that the 400 will still send the entity correctly.
        property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, "true");
        registerModules();
    }