@Module(
        injects = Main.class
)
public class ExampleTestModule {
    @Provides
    public Bar providesBar(BarImpl impl) {
        return impl;
    }
}