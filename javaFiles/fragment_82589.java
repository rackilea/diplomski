@Module (injects = {MyPresenter.class})
public class RootModule {
    private Context context;

    public RootModule(BaseApplication application) {
        this.context = application.getApplicationContext();
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }
}