@Override
public void doWithRequest(ClientHttpRequest request) throws IOException {
  HttpHeaders httpHeaders = request.getHeaders();
  List<MediaType> acceptableMediaTypes = new LinkedList<>();
  acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
  httpHeaders.setAccept(acceptableMediaTypes);
  httpHeaders.setContentType(MediaType.APPLICATION_JSON);
  request.getBody().write(
      new Gson().toJson(this.searchCustomer).getBytes(StandardCharsets.UTF_8.displayName()));

  ClientHttpResponse response = request.execute();
  String sessionId = response.getHeaders().get(HttpHeaders.SET_COOKIE).split(":")[1].trim(); // I didnt test this, will prolly get a NPE :P
  this.sessionId = sessionId;
}