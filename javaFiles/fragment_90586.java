public class ExampleClass {
    public static void main(String[] args) {
        // this method is static - see the key word in the signature
        new ExampleClass().execute();
    }

    public void execute() {
        // this is an instance method
        Class<?> type = new ByteBuddy()
                              .subclass(Object.class)
                              .make()
                              .load(getClass().getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                              .getLoaded();
    }
}