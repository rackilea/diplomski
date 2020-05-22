URI exampleURI = URI.create("https://www.stackoverflow.com");

AsyncRestTemplate template = new AsyncRestTemplate/* specific request factory*/();
var future1 = template.exchange(exampleURI, HttpMethod.GET, null, String.class).completable();
var future2 = template.exchange(exampleURI, HttpMethod.GET, null, String.class).completable();
var future3 = template.exchange(exampleURI, HttpMethod.GET, null, String.class).completable();

CompletableFuture.allOf(future1, future2, future3).thenRun(() -> {
    // you're done
});