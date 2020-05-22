DefaultHttpClient httpClient = new DefaultHttpClient();
HttpGet getRequest = new HttpGet("http://localhost:8080/users/2");
HttpResponse response = httpClient.execute(getRequest);
HttpEntity httpEntity = response.getEntity();
String userString = EntityUtils.toString(httpEntity);
// Transform 'userString' into object using for example GSON:
Gson gson = new Gson();
User user = gson.fromJson(userString, User.class);
System.out.println("Username:    " + user.getUsername());