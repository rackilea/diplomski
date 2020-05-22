public String getText(String uri) {
    HttpClient client1 = new DefaultHttpClient();
    HttpGet request = new HttpGet(uri);

    ResponseHandler<String> responseHandler = new BasicResponseHandler();
    try {
        String response_str = client1.execute(request, responseHandler);
        return response_str;

    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return "";

    }
}