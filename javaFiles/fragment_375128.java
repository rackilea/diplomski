@Configuration
public class AuthenticationFilterConfiguration implements ServletContextInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationFilterConfiguration.class);

    public AuthenticationFilterConfiguration(){
        LOGGER.info("Setting up authentication filter");
    }

    @Override
    public void onStartup(ServletContext context) throws ServletException {
        LOGGER.info("Authentication filter configured");
    }

}