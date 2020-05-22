public abstract class Super {

    public static void main(String[] args) {
        new Sub();
    }

    public Super() {
        printMe();
    }

    abstract void printMe();

    private static class Sub extends Super {

        private final Object x = new Object();

        public Sub() {
            super();
            printMe();
        }

        @Override
        protected void printMe() {
            System.out.println("printMe: " + x);
        }
    }
}