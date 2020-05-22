public static Object getEvent2(int id, String name, String username, String password, String since, String to, 
        String reg, String nalog, String status, String value ) throws Exception {

    String response= null;
    String xml = null;

    HttpClient httpClient = new DefaultHttpClient();
    HttpPost httpPost = new HttpPost(Konstante.URL);

    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    envelope.encodingStyle = SoapSerializationEnvelope.ENC;

    String bodyOut = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">";
    bodyOut += "<soap:Body><"+Konstante.EVENS_METHOD_NAME+" xmlns=\"" + Konstante.NAMESPACE + "\">";
    bodyOut += "<User><ID>" + id + "</ID><Name>" + name + "</Name><UserName>";
    bodyOut += username + "</UserName><Password>" + password + "</Password></User>";
    bodyOut += "<Filter><TimeSpan><Since>" + since + "+02:00" + "</Since><To>" + to + "+02:00" +"</To></TimeSpan>";
    bodyOut += "<Reg>" + reg + "</Reg><Nalog>" + nalog + "</Nalog><Status>" + status + "</Status><Value>" + value + "</Value></Filter>";
    bodyOut += "</"+Konstante.EVENS_METHOD_NAME+"></soap:Body></soap:Envelope>";

    xml = bodyOut;

    StringEntity se = new StringEntity(xml, HTTP.UTF_8);
    se.setContentType("text/xml");
    httpPost.addHeader(Konstante.EVENS_SOAP_ACTION, Konstante.URL);
    httpPost.setEntity(se);

    HttpResponse httpResponse = httpClient.execute(httpPost);
    HttpEntity resEntity = httpResponse.getEntity();
    response = EntityUtils.toString(resEntity);

    return response;
}