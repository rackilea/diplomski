public class Example {

    public static void main(String[] args) {
        Type t1 = new Type("foo");
        Type t2 = new Type("bar");
        Type t3 = new Type("baz");

        Printer.<Type> printNames(t1, t2, t3);
    }

    public static class Printer {
        @SafeVarargs
        public static <T extends Type> void printNames(T... objs) {
            for (T obj : objs) {
                System.out.println(obj);
            }
        }
    }

    public static class Type {
        private final String name;

        public Type(String name) {
            this.name = name;
        }

        @Override
        public final String toString() {
            return name;
        }
    }
}