class Test {

    private static class Test3 {
        private void print1() {
            System.out.println("non-polymorphic 1");
        }

        void polymorphic() {
            System.out.println("polymorphic 1");
        }
    }

    private static class Test4 extends Test3 {
        private void print1() {
            System.out.println("non-polymorphic 2");
        }

        void polymorphic() {
            System.out.println("polymorphic 2");
        }
    }

    public static void main(String[] args) {
        Test4 t4 = new Test4();
        t4.print1();
        t4.polymorphic();

        System.out.println("======");

        Test3 t34 = new Test4();
        t34.print1();
        t34.polymorphic();
    }
}