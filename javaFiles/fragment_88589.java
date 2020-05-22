public static String getJsonData(String webServiceName,String parameter)
{  
    try  
    {
    String urlFinal=SERVICE_URI+"/"+webServiceName+"?parameter=";
    HttpPost postMethod = new HttpPost(urlFinal.trim()+""+URLEncoder.encode(parameter,"UTF-8"));
    postMethod.setHeader("Accept", "application/json");
    postMethod.setHeader("Content-type", "application/json");

    HttpClient hc = new DefaultHttpClient();

    HttpResponse response = hc.execute(postMethod);
    Log.i("response", ""+response.toString());
    HttpEntity entity = response.getEntity();
    final String responseText = EntityUtils.toString(entity);

    string=responseText;
    Log.i("Output", ""+responseText);
      }
      catch (Exception e) {
    }

return string;
}