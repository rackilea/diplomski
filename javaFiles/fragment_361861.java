CompletableFuture<Void> allof = CompletableFuture.allOf(future1, future2, future3);
allof.get();

if (allof.isDone ()) {
    System.out.println("Future result " + future1.get() + " | " + future2.get() + " | " + future3.get());
} else {
    System.out.println("Futures are not ready");
}