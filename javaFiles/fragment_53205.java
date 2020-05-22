public class MyModule extends AbstractModule {

    // other providers
    // ...

    @Provides
    @Singleton
    public DSLContext dslContext(Configuration configuration) {
        return SL.using(configuration);
    }
}