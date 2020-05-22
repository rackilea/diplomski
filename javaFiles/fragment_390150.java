public class CacheModule extends AbstractModule {
    /** This isn't needed anymore; the @Provides method below is sufficient. */
    @Override protected void configure() {}

    /** This keeps a WidgetCache per thread and knows how to create a new one. */
    private ThreadLocal<WidgetCache> threadWidgetCache = new ThreadLocal<>() {
        @Override protected WidgetCache initialValue() {
            return new WidgetCache(...lots of params);
        }
    };

    /** Provide a single separate WidgetCache for each thread. */
    @Provides WidgetCache provideWidgetCache() {
        return threadWidgetCache.get();
    }
}