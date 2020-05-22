//step 1
HttpClient client = new DefaultHttpClient();
for(int i=0;i<=50;i++) {
    HttpGet request = new HttpGet("my_url");
    HttpResponse response = client.execute(request);
    System.out.println(response.getStatusLine().getStatusCode());
    //step 2
    BufferedReader br = new BufferedReader(
        new InputStreamReader(response.getEntity().getContent()));
    //since you won't use the response content, just close the stream
    br.close();
}