@Test
public void shouldTestGreeterService() throws Exception {

    Greeter service = new Greeter();

    HelloRequest req = HelloRequest.newBuilder()
            .setName("hello")
            .build();

    StreamObserver<HelloRequest> observer = mock(StreamObserver.class);

    service.sayHello(req, observer);

    verify(observer, times(1)).onCompleted();

    ArgumentCaptor<HelloReply> captor = ArgumentCaptor.forClass(HelloReply.class);

    verify(observer, times(1)).onNext(captor.capture());

    HelloReply response = captor.getValue();

    assertThat(response.getStatus(), is(true));
}