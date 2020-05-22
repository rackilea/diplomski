public class Foo {
    public static void main(String [] args) {
        bar();
    }

    public static void bar() {
        System.out.println("compiler won't complain");
    }
}