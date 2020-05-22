when(httpClient.execute(any(), any())).thenAnswer(new Answer<Future<HttpResponse>>() {

    @Override
    public Future<HttpResponse> answer(InvocationOnMock invocation) throws Throwable {
        verify(httpClient).execute(requestCaptor.capture(), futureCallbackCaptor.capture());
        futureCallbackCaptor.getValue().completed(response);
        return future;
    }
});