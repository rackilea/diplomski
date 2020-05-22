public static <T> ResponseModel<T> Get(Class<?> classType, String requestUri) throws ClientProtocolException, IOException 
{
    CloseableHttpClient client = HttpClientBuilder.create().build();
    HttpGet httpGet = new HttpGet(requestUri);
    httpGet.addHeader("accept", "application/json");
    HttpResponse response = client.execute(httpGet);
    ResponseModel<T> responseModel = new ResponseModel<T>();
    if (response.getStatusLine().getStatusCode() == 200) 
    {
        responseModel.setObject((T) Utils.fromJson(EntityUtils.toString(response.getEntity()), classType));
        responseModel.setIsRequestSuccessful(true);
    } 
    else 
    {
        responseModel.setMessage(response.getEntity().getContent().toString());
        responseModel.setIsRequestSuccessful(false);
    }
    return responseModel;
}