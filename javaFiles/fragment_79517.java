@Module
public class MyModule {

    @Provides
    MyInterface providesMyInterface() {
        return new MyInterface() {
        };
    }

    @Provides
    MyClassUsingMyInterface providesMyClass(MyInterface myInterface) {
        return new MyClassUsingMyInterface(myInterface);
    }
}