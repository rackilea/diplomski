public static String callWebServiceMethod(String email){
HttpClient httpClient = new DefaultHttpClient();
HttpPost httpPost = new HttpPost("http://www.example.com/example.asmx");
String  webServiceXml = "";
String  response = "";

try
{
    webServiceXml += "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
    webServiceXml += "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">";
    webServiceXml += "<soap:Header>";
    webServiceXml += "<AuthHeader xmlns=\"http://www.example.com/\">";
    webServiceXml += "</AuthHeader>";
    webServiceXml += "</soap:Header>";
    webServiceXml += "<soap:Body>";
    webServiceXml += "<WebServiceMethod1 xmlns=\"http://www.example.com/\">";
    webServiceXml += "<emailId>" + email + "</emailId>";
    webServiceXml += "</WebServiceMethod1>";
    webServiceXml += "</soap:Body>";
    webServiceXml += "</soap:Envelope>";

    httpPost.setHeader("content-type","text/xml; charset=utf-8");
    httpPost.setHeader("SOAPAction","http://www.example.com/WebServiceMethod1");

    httpPost.setEntity(new StringEntity(webServiceXml));

    HttpResponse httpResponse = httpClient.execute(httpPost);

    response = EntityUtils.toString(httpResponse.getEntity());
}
catch(Exception ex)
{
    Log.i("error", ex.getMessage());
}

return response;