HttpClient httpClient = HttpClientBuilder.create().build();
HttpPost httpPost = new HttpPost("http://naviserver.azurewebsites.net/api/Person");
Person person = new Person("dave", 30);
Gson gson = new Gson();  
String json = gson.toJson(person);
StringEntity body = new StringEntity(json);
httpPost.setEntity(body);
HttpResponse response = httpClient.execute(httpPost);