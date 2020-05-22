HttpClient client = new DefaultHttpClient();
HttpGet request = new HttpGet("http://www.google.com/");
try {
    HttpResponse response = client.execute(request);
    txtResult.setText(HttpHelper.request(response));
    // internet is working 
} catch(Exception ex) {
    // internet is not working
    txtResult.setText("Internet ENOWORK");
}