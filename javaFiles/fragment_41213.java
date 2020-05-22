class Foo {
    public static int x = 1;

    public static Foo dummyFoo() throws InterruptedException {
        Thread.sleep(5000);
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(dummyFoo().x);
        System.out.println(Foo.x);
    }
}