@Singleton // <---- Add this line
    @Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class})
    public interface AppComponent {

        @Component.Builder
        interface Builder {
          @BindsInstance Builder application(Application application);
          AppComponent build();
        }

        void inject(AndroidSampleApp app);
    }