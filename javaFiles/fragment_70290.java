class Foo {
    private static final Random random = new Random() {
        {
            System.out.println("random initialized");
        }
    };
...