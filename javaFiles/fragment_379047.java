class Test {

    public static void main(String[] args) throws Exception {

        long millisBefore = System.currentTimeMillis();

        List<String> strings = Arrays.asList("1","2", "3", "4", "5", "6", "7", "8");
        List<CompletableFuture<String>> listOfFutures = strings.stream().map(Test::downloadWebPage).collect(toList());
        CompletableFuture<List<String>> futureOfList = CompletableFuture
                .allOf(listOfFutures.toArray(new CompletableFuture[0]))
                .thenApply(v ->  listOfFutures.stream().map(CompletableFuture::join).collect(toList()));

        System.out.println(futureOfList.get()); // blocks here
        System.out.printf("time taken : %.4fs\n", (System.currentTimeMillis() - millisBefore)/1000d);
    }

    private static CompletableFuture<String> downloadWebPage(String webPageLink) {
        return CompletableFuture.supplyAsync( () ->{
            try { TimeUnit.SECONDS.sleep(4); }
            catch (Exception io){ throw new RuntimeException(io); }
            finally { return "downloaded : "+ webPageLink; }
            });
    }

}