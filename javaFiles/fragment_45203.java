try
{
    HttpClient httpClient = new DefaultHttpClient();
    URI uri = new URI("https", "s3-eu-west-1.amazonaws.com", "/developer-application-test/cart/list", null, null);
    HttpGet httpGet = new HttpGet(uri);
    HttpResponse httpResponse = httpClient.execute(httpGet);
    HttpEntity httpEntity = httpResponse.getEntity();
    if (httpEntity != null)
    {
        InputStream inputStream = httpEntity.getContent();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String currentLine = null;
        while ((currentLine = bufferedReader.readLine()) != null)
        {
            stringBuilder.append(currentLine + "\n");
        }
        String result = stringBuilder.toString();
        Log.v("Http Request Results:",result);
        inputStream.close();
    }
}
catch (Exception e)
{
    e.printStackTrace();
}