@GetMapping(path = "/testingAsync")
public DeferredResult<String> value() throws ExecutionException, InterruptedException, TimeoutException {
   AsyncRestTemplate restTemplate = new AsyncRestTemplate();
   String baseUrl = "http://someUrl/blabla";
   HttpHeaders requestHeaders = new HttpHeaders();
   requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
   String value = "";

   HttpEntity entity = new HttpEntity("parameters", requestHeaders);
   final DeferredResult<String> result = new DeferredResult<>();
   ListenableFuture<ResponseEntity<someClass>> futureEntity = restTemplate.getForEntity(baseUrl, someClass.class);

   futureEntity.addCallback(new ListenableFutureCallback<ResponseEntity<someClass>>() {
      @Override
      public void onSuccess(ResponseEntity<someClass> result) {
         System.out.println(result.getBody().getName());
         result.setResult(result.getBody().getName());
      }

      @Override
      public void onFailure(Throwable ex) {
         result.setErrorResult(ex.getMessage());
      }
  });

  return result;
}