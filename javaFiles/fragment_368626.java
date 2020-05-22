@Nonnull
public HttpResponse executeRestClientServiceCall(HttpUriRequest request) throws IOException {
  HttpClient client = new DefaultHttpClient();
  HttpResponse httpResponse = client.execute(request);
  try {
    // ... other code ...
  } finally {
    HttpEntity entity = httpResponse.getEntity();
    if (entity != null) {
      entity.getContent().close();
    }
  }
  return httpResponse;
}