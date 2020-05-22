public class Foo {

    private static final RuntimeException re = new RuntimeException("MSG");

    public static void main(String[] args) {
        try {
            Integer.parseInt("!!#!");
        } catch (Exception e) {
            throw re;
        }
    }
}