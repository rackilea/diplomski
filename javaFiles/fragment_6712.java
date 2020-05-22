HttpTransport httpTransport = new NetHttpTransport();
HttpRequestFactory httpRequestFactory = httpTransport.createRequestFactory();

String data = "query=" + query;
HttpContent content = new ByteArrayContent("application/x-www-form-urlencoded", data.getBytes());
GenericUrl url = new GenericUrl("https://www.googleapis.com/freebase/v1/mqlread");

HttpRequest request = httpRequestFactory.buildPostRequest(url, content);
HttpHeaders headers = new HttpHeaders();
headers.put("X-HTTP-Method-Override","GET");
request.setHeaders(headers);

HttpResponse response = request.execute();