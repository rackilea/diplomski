public class Foo {

    public static void main(String[] args) throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> foo());
        future.get();
    }

    private static void foo() {
        System.out.println("foo");
    }

}