public class Example {

    public static void main(String[] args) {
        Printer.printNames("a", "b", new Type("foo"), new Type("bar"));
    }

    public static class Printer {
        public static void printNames(Object... objs) {
            for (Object obj : objs) {
                if (obj instanceof String) {
                    System.out.println(((String) obj).toUpperCase());
                }
                else if (obj instanceof Type) {
                    System.out.println(obj);
                }
            }
        }
    }

    public static class Type {
        private final String name;
        public Type(String name) { this.name = name; }
        public final String toString() { return name; }
    }
}