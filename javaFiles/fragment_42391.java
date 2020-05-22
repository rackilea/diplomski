@Inject
public ApplicationResource(ServiceLocator locator) {
    GuiceBridge.getGuiceBridge().initializeGuiceBridge(locator);
    // add your Guice modules.
    Injector injector = Guice.createInjector(new GuiceModule());
    GuiceIntoHK2Bridge guiceBridge = locator.getService(GuiceIntoHK2Bridge.class);
    guiceBridge.bridgeGuiceInjector(injector);
}