public class GuiceFactory {

    private static final Injector injector = Guice.createInjector(new RpgaAppModule());

    public static Injector getInjector() {
        return injector;
    }
}