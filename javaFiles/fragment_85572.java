public final class Testcase
{
    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        Random random = new Random();
        Supplier<CompletableFuture<Integer>> cache = Suppliers.memoize(() ->
        {
            return CompletableFuture.supplyAsync(() ->
            {
                return random.nextInt();
            });
        });
        for (int i = 0; i < 10; ++i)
            System.out.println(cache.get().get());
    }
}