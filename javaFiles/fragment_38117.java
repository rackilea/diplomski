public class ListInjectorWrapper {
    private final Injector injector;

    @Inject
    ListInjectorWrapper(Injector injector) {
        this.injector = injector;
    }

    @SafeVarargs
    public final <T> List<T> getList(Class<? extends T>... classes) {
        return Arrays.stream(classes).map(clazz -> injector.getInstance(clazz))
            .collect(Collectors.toList());
    }
}