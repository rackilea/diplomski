@Module
public abstract class MainFragmentPresenterModule {
    ...
    @Binds
    abstract MainFragmentPresenter(MainFragmentPresenterImpl impl);
}