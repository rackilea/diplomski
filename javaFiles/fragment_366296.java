private static class HttpGetWithEntity extends
        HttpEntityEnclosingRequestBase {
    public final static String METHOD_NAME = "GET";

    @Override
    public String getMethod() {
        return METHOD_NAME;
    }
} 

private void getslotsCount() throws IOException,
        URISyntaxException {

    HttpGetWithEntity httpEntity = new HttpGetWithEntity();
    URL slots = new URL("http://hostname:4444/grid/api/hub");

    httpEntity.setURI(pendingRequests.toURI());

    httpEntity
            .setEntity(new StringEntity("{\"configuration\":[\""
                    + PENDING_REQUEST_COUNT + "\"]}",
                    ContentType.APPLICATION_JSON));
    HttpClient client = HttpClientBuilder.create().build();
    HttpResponse response = client.execute(getPendingRequests);
    BufferedReader rd = new BufferedReader(new InputStreamReader(response
            .getEntity().getContent()));

    // At this point I can just get the response using readLine()
    System.out.println(rd.readLine());

}