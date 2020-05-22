public class EnclosingClass {
    public interface ClassFactory {
        public SomeClass getInstance(int which);
    }
    public static final ClassFactory CLASS_FACTORY;

    private static class ClassFactoryImpl implements ClassFactory {
        public SomeClass getInstance(int which) { /* ... */ }
    }

    static {
        CLASS_FACTORY = new ClassFactoryImpl();
    }
}