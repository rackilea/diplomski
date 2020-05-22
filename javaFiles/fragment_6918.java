public static String postData(String base, List<BasicNameValuePair> data) throws IOException {
    // Create a new HttpClient and Post Header
    HttpClient httpclient = new DefaultHttpClient();
    HttpPost httppost = new HttpPost(base);
    HttpResponse response = null;
    String line = "";
    StringBuilder total = new StringBuilder();
    HttpProtocolParams.setUseExpectContinue(httpclient.getParams(), false);

    try {
        httppost.setEntity(new UrlEncodedFormEntity(data));

        // Execute HTTP Post Request
        response = httpclient.execute(httppost);

        // Wrap a BufferedReader around the InputStream
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        // Read response until the end
        while ((line = rd.readLine()) != null) {
            total.append(line);
            total.append("\n"); //I'VE JUST ADDED THIS LINE
        }

    } catch (ClientProtocolException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    // Return full string
    return total.toString();
}