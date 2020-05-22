public class ClassA {

    // Constructors only called by builder.

    public static class Builder {
        // builder code.
        public static void hello() {
            System.out.println("Hello");
        }

        public void hello1() {
            System.out.println("Hello1");
        }
    }
}