HttpClient httpClient = new DefaultHttpClient();

try {
    HttpPost request = new HttpPost("http://yoururl");
    StringEntity params =new StringEntity("details={\"name\":\"myname\",\"age\":\"20\"} ");
    request.addHeader("content-type", "application/json");
    request.addHeader("Accept","application/json");
    request.setEntity(params);
    HttpResponse response = httpClient.execute(request);

    // handle response here...
}catch (Exception ex) {
    // handle exception here
} finally {
    httpClient.getConnectionManager().shutdown();
}