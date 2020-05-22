public class Foo {
    public static void main(final String[] args) {
        final byte[] b1 = {-17, -69, -65, 83, 72, 69, 79, 71, 77, 73, 79, 70};
        final byte[] b2 = {83, 72, 69, 79, 71, 77, 73, 79, 70};

        final String s1 = new String(b1).replace("\uFEFF", "");
        final String s2 = new String(b2).replace("\uFEFF", "");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1.equals(s2));
    }
}