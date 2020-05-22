interface A {
   public void show();
}

public class Foo {
    public static void main(String[] a) {

        new A() {
            @Override
            public void show() {
                System.out.println("Hello");
            }
        }.show();
    }
}