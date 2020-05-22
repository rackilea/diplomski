public static void main(String[] args) throws Exception {
    String googleUrl = "http://www.google.com";
    String microsoftUrl = "http://www.microsoft.com";
    AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
    ListenableFuture<ResponseEntity<String>> googleFuture = asyncRestTemplate.exchange(googleUrl, HttpMethod.GET, null, String.class);
    ListenableFuture<ResponseEntity<String>> microsoftFuture = asyncRestTemplate.exchange(microsoftUrl, HttpMethod.GET, null, String.class);
    final CountDownLatch countDownLatch = new CountDownLatch(2);
    ListenableFutureCallback<ResponseEntity<java.lang.String>> listenableFutureCallback = new ListenableFutureCallback<ResponseEntity<String>>() {

        public void onSuccess(ResponseEntity<String> stringResponseEntity) {
            System.out.println(String.format("[Thread %d] Status Code: %d. Body size: %d",
                    Thread.currentThread().getId(),
                    stringResponseEntity.getStatusCode().value(),
                    stringResponseEntity.getBody().length()
            ));
            countDownLatch.countDown();
        }

        public void onFailure(Throwable throwable) {
            System.err.println(throwable.getMessage());
            countDownLatch.countDown();
        }
    };
    googleFuture.addCallback(listenableFutureCallback);
    microsoftFuture.addCallback(listenableFutureCallback);
    System.out.println(String.format("[Thread %d] This line executed immediately.", Thread.currentThread().getId()));
    countDownLatch.await();
    System.out.println(String.format("[Thread %d] All responses received.", Thread.currentThread().getId()));

}