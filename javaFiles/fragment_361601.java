public class Foo {
    public void bar() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };
    }

    private void baz() {
    }
}