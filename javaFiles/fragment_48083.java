public void posthttp()
{

    URL= your url
    InputStream is = null;
    String val1;
    String val2;
    ArrayList<NameValuePair> namevaluepair =new  ArrayList<NameValuePair>();

    //Making HTTP request
    try {
        // defaultHttpClient
        DefaultHttpClient httpClient = new DefaultHttpClient();

        namevaluepair.add(new BasicNameValuePair("val1",val1));
        namevaluepair.add(new BasicNameValuePair("val2",val2));


        String enc_url = urlEncode(URL);
        HttpPost httpPost = new HttpPost(enc_url );

         httpPost.setEntity(new UrlEncodedFormEntity(namevaluepair));
         HttpResponse httpResponse = httpClient.execute(httpPost);
         HttpEntity httpEntity = httpResponse.getEntity();
        is = httpEntity.getContent();            

    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                is, "iso-8859-1"), 8);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        is.close();
        String responseFromServer = sb.toString();

    } catch (Exception e) {
        Log.e("Buffer Error", "Error converting result " + e.toString());
    }

}