public String postData(int myUserId) {
    HttpClient httpclient = new DefaultHttpClient();
    HttpPost httppost = new HttpPost("http://www.gallopshop.eu/OFY/getConversations.php");
    try {
        // Add your data
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("id", Integer.toString(myUserId)));
        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        HttpResponse response = httpclient.execute(httppost);
        String responseStr = EntityUtils.toString(response.getEntity());
        return responseStr;
    } catch (ClientProtocolException e) {
        // TODO Auto-generated catch block
    } catch (IOException e) {
        // TODO Auto-generated catch block
    }
    return null;
}