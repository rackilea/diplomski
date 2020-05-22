public class AFactory {

    public static int currentRange;

    private static abstract class A {
        protected final Object range = AFactory.currentRange;
    }

    public static class B extends A {
        public int congreteRange = 42;
    }

    synchronized A createNew(Class<? extends B> clazz) throws Exception {
        currentRange = clazz.newInstance().congreteRange;
        return clazz.newInstance();
    }

    public static void main(String[] args) throws Exception {
        AFactory factory = new AFactory();
        System.out.println(factory.createNew(B.class).range);
    }
}