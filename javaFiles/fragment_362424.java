public class MyModule extends AbstractModule {

    private static final Class<MyInterface> myInterfaceClass = getMyInterfaceClass();

    @SuppressWarnings("unchecked")
    private static Class<MyInterface> getMyInterfaceClass() {
        try {
            return (Class<MyInterface>) Class.forName("ConcreteImplementationA");
        } catch (ClassNotFoundException e) {
            try {
                return (Class<MyInterface>) Class.forName("ConcreteImplementationB");
            } catch (ClassNotFoundException e1) {
                // Handle no implementation found
            }
        }
    }

    @Provides
    MyInterface provideMyInterface() {
        return myInterfaceClass.newInstance();
    }
}