@ApplicationPath("api")
public class ApiRest extends ResourceConfig {  
    private static final Logger log = LoggerFactory.getLogger(ApiRest.class);

    @Inject
    public ApiRest(ServiceLocator serviceLocator, ServletContext servletContext) {
        log.debug("Inicialitzant Jersey.");
        packages("net.sargue.app.api");

        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        Injector injector = (Injector) servletContext.getAttribute(Injector.class.getName());
        if (injector == null)
            throw new RuntimeException("Guice Injector not found");
        guiceBridge.bridgeGuiceInjector(injector);
    }
}