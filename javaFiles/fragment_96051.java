while (running) {

HttpClient client = new DefaultHttpClient();
HttpGet GET = new HttpGet("mydomain.com/path.html");
HttpResponse response = client.execute(GET);
// do stuff with response

}