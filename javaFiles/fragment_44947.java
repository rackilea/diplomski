@Test
public void testCapture() {
  //Instead of using client.toBlocking().retrieve(...)
  /*
  String redirectUrl = client.toBlocking()
      .retrieve(HttpRequest.POST("/some/endpoint",  body), String.class);
  */

  // Use client.exchange(...)
  Publisher<HttpResponse<Object>> exchange =
    client.exchange(HttpRequest.POST("/payment/1234567890/capture", body)
        .contentType(MediaType.APPLICATION_FORM_URLENCODED), Object.class);

  TestSubscriber<HttpResponse<?>> testSubscriber = new TestSubscriber<HttpResponse<?>>() {
    @Override
    public void onNext(HttpResponse<?> httpResponse) {
      assertNotNull(httpResponse);
      assertEquals(HttpStatus.SEE_OTHER, httpResponse.status());
      assertEquals(getRedirectUri(), httpResponse.header("location"));
    }
  };

  exchange.subscribe(testSubscriber);

  // await to allow for response
  testSubscriber.awaitTerminalEvent(2, TimeUnit.SECONDS);

  // assert for errors, completion, terminated etc.
  testSubscriber.assertNoErrors();
  testSubscriber.assertComplete();
  testSubscriber.assertTerminated();
}