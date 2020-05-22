public class Test {

    public static void main(String[] args) {
        Nested nested = new Nested();
        System.out.println(nested.x);
    }

    private static class Nested {
        private int x;
    }
}