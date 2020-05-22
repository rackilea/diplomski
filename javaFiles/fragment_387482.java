.
.

String username = ....
String password = ....
DefaultHttpClient httpClient = new DefaultHttpClient();
if (username != null) {
  httpClient.getCredentialsProvider().setCredentials(
       new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
       new UsernamePasswordCredentials(username, password));
}

.
.


httpClient.execute(your_http_request); 

.
.