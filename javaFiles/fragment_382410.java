PipedInputStream pipedInputStream = new PipedInputStream();
  PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);
  BodyDeferringAsyncHandler bodyDeferringAsyncHandler = new BodyDeferringAsyncHandler(pipedOutputStream);
  Future<Response> futureResponse = asyncHttpClient.prepareGet(url).execute(bodyDeferringAsyncHandler);
  Response response = bodyDeferringAsyncHandler.getResponse();
  if (response.getStatusCode() == 200) {
    return new BodyDeferringAsyncHandler.BodyDeferringInputStream(futureResponse,
        bodyDeferringAsyncHandler,
        pipedInputStream);
  } else {
    return null;
  }