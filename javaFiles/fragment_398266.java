public class RestyGwtConfig {

    @Inject
    public RestyGwtConfig(RestyDispatcher dispatcher) {
        Defaults.setDispatcher(dispatcher);
    }

    static {
    // GWT.log("--> RestyGwtConfig -> setServiceRoot");
    Defaults.setServiceRoot(new Resource(GWT.getModuleBaseURL()).resolve(ServiceRouting.SERVICE_ROOT).getUri());
    UserCredentials.INSTANCE.setUserName("ronan");
    UserCredentials.INSTANCE.setPassword("password");
    }
}