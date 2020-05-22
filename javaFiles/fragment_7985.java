public class AFactory {

    public int currentRange;

    private abstract class A {
        protected final Object range = currentRange;
    }

    public class B extends A {
        public int congreteRange = 42;
    }

    synchronized A createNew(Constructor<? extends A> ctor) throws Exception {
        // Pass `this` as argument to constructor. 
        // `this` is reference to current enclosing instance
        return ctor.newInstance(this); 
    }

    public static void main(String[] args) throws Exception {
        AFactory factory = new AFactory();

        // Get constructor of the class with `AFactory` as parameter
        Class<B> bClazz = B.class;
        Constructor<B> ctor = bClazz.getDeclaredConstructor(AFactory.class);

        System.out.println(factory.createNew(ctor));
    }
}