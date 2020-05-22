@Override
public ArrayList<SimpsonResult> loadDataFromNetwork() throws IOException {
  HttpRequestFactory requestFactory = getHttpRequestFactory();
  GenericUrl url = new GenericUrl(baseUrl);
  HttpRequest request = requestFactory.buildGetRequest(url);

  Type type = new TypeToken<ArrayList<SimpsonResult>>() {}.getType();
  return request.execute().parseAs(type);
}