public class CacheModule extends AbstractModule {
    @Override
    protected void configure() {
        bindScope(ThreadScoped.class, new ThreadScope());
    }

    /** Provide a single separate WidgetCache for each thread. */
    @Provides @ThreadScoped WidgetCache provideWidgetCache() {
        return new WidgetCache(...lots of params);
    }
}