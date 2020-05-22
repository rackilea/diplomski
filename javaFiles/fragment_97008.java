val future1: CompletableFuture<String> = CompletableFuture.supplyAsync {
    println("This is your thread 1 code")
    "<html><head><title>"
}

val future2: CompletableFuture<String> = CompletableFuture.supplyAsync {
    println("This is your thread 2 code")
    if (Random().nextBoolean()) throw RuntimeException("Failed")
    "Title!</title></html></head>"
}

future1.thenCombine(future2, {result1, result2 -> result1 + result2}).whenComplete { s, throwable ->
    if (throwable != null) {
        println("failed")
    } else {
        println("done with $s")
    }
}