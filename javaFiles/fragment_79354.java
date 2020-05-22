public static void main(String[] args) throws Exception {

  URI firstURI = new URI("http://example.com:80");
  URI secondURI = new URI("http://example.com/testing");

  boolean sameHost = firstURI.getHost().equals(secondURI.getHost());
  boolean sameScheme = firstURI.getScheme().equals(secondURI.getScheme());
  boolean samePort = getPort(firstURI) == getPort(secondURI);

  if(sameHost && sameScheme && samePort) {
    System.out.println("ok");
  } else {
    System.out.println("error");
  }

}

private static int getPort(URI uri) {
  int port = uri.getPort();
  // if port is undefined, set it to its default value depending on the scheme
  if(port == -1) {
    port = "https".equals(uri.getScheme()) ? 443 : 80;
  }
  return port;
}