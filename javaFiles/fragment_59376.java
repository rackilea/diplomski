DefaultHttpClient httpClient = new DefaultHttpClient();
HttpPost postRequest = new HttpPost("http://localhost:8080/TESTINGrestful/rest/polls/comment");
StringEntity input = new StringEntity("<Comment>...</Comment>");
input.setContentType("text/xml");
postRequest.setEntity(input);
HttpResponse response = httpClient.execute(postRequest);