URL url = new URL("file:/D:/Projects/Mywsdl.wsdl");
    QName qname = new QName("http://adresse/", "ImpWSService");
    Service service = Service.create(url, qname);
    //web service Interface
    DomaineIntWS domaineIntWS = service.getPort(DomaineIntWS.class);
    try {
    String echo = domaineIntWS.echocall("xxx");
    } catch (Exception e) {
      //do something with a possible exception
    } finally {

    BindingProvider bpDomaineIntWS = (BindingProvider) domaineIntWS;
    int httpResponseCode =(Integer) bpDomaineIntWS.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE);

}