@Module
public class MyModule {

    @Provides
    MyInterface providesMyInterface() {
        return new MyInterface() {
            // my super awesome implementation. MIT license applies.
        };
    }
}