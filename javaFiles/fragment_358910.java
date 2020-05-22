package reflectionexp;

    public class DiscoveredClass {

        public static void methodStatic(int x, String string) {
            System.out.println("static method with " + x + " and " + string);
        }

        public void methodInstance(int x, String string) {
            System.out.println("instance method with " + x + " and " + string);
        }

    }