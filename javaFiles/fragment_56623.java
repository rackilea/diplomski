@Singleton
public interface AppComponent extends AndroidInjector<YourApplicationClass> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }

    void inject(NotifWorker worker);
}