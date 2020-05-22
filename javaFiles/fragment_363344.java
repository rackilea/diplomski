public class LaunchPadTokenRetriever {  

   public static void main(String[] args) throws ClientProtocolException,       IOException{

    CloseableHttpClient httpclient = HttpClients.createDefault();

    HttpPost httpPost = new HttpPost("https://launchpad.net/+request-token");
    httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");

    List <NameValuePair> urlParams = new ArrayList <NameValuePair>();
    urlParams.add(new BasicNameValuePair("oauth_signature", "&"));
    urlParams.add(new BasicNameValuePair("oauth_consumer_key", "tester"));
    urlParams.add(new BasicNameValuePair("oauth_signature_method", "PLAINTEXT"));
    httpPost.setEntity(new UrlEncodedFormEntity(urlParams));
    CloseableHttpResponse response = httpclient.execute(httpPost);
    System.out.println(response);

    try {
      System.out.println(response.getStatusLine());
      HttpEntity entity = response.getEntity();
      ResponseHandler<String> responseHandler = new BasicResponseHandler();
      String responseBody =  httpclient.execute(httpPost, responseHandler);
      System.out.println("Initial credentials ---> "+ responseBody);
      System.out.println();    
      String getresponse = responseBody;

      EntityUtils.consume(entity);
    } finally {
      response.close();
    }
  }

}