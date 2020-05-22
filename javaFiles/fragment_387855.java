public static void main(String[] args) {
    CompletableFuture<Void> future = runAsync("run async command ans wait 10000");
    future.join();
    System.out.println("sync commands ");
}

public static CompletableFuture<Void> runAsync(String inputStr) {
    return CompletableFuture.runAsync(() -> {
        List<String> strings = Arrays.asList(inputStr.split(" "));
        int sleep = Integer.parseInt(strings.get(strings.size() - 1));
        try {
            sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("async command ");
    });
}