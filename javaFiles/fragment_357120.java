String ipStr = "the.proxy.ip.string";
int port = 8080;
String proxyLogin = "your login name";
String proxyPassword = "your password";

httpClient.getCredentialsProvider().setCredentials(
    new AuthScope(ipStr, port),
    new UsernamePasswordCredentials(proxyLogin, proxyPassword));

HttpHost httpHost = new HttpHost(ipStr, port, "http");      
httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, httpHost);