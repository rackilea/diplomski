@Module(
    injects = {MainActivity.class,SecondActivity.class}
)
public class DependencyModule {

    @Singleton
    @Provides
    public Repository getSingle(){
        return new InMemoryRepository();
    }
}