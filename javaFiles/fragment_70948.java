HttpClient client = vertx.createHttpClient(new HttpClientOptions().setSsl(true).setTrustAll(true));
HttpClientRequest request = client.post(443, "login.windows.net", "/common/oauth2/token").handler(res->{
                System.out.println(res.statusCode());
     }).putHeader(HttpHeaders.CONTENT_LENGTH,String.valueOf(buffer.length()))
.putHeader(HttpHeaders.CONTENT_TYPE,"application/x-www-form-urlencoded").write(buffer);
request.end();