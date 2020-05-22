Pattern REQUEST_TARGET_ORIGIN_FORM_PREFIX = Pattern.compile("/[^/]");

@Override
public HttpResponse clientToProxyRequest(HttpObject httpObject) {
  if (httpObject instanceof HttpRequest) {
    HttpRequest httpRequest = (HttpRequest) httpObject;
    if (REQUEST_TARGET_ORIGIN_FORM_PREFIX.matcher(httpRequest.getUri()).lookingAt()) {
      String uriRemote = "http://myRemoteHost:myRemotePort" + httpRequest.getUri();
      httpRequest.setUri(uriRemote);
    }
  }
  return null;
}