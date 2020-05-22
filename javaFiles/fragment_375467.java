public Object callWebService(MyRequest request){
    MyResponse myObj = (MyResponse)getWebServiceTemplate().marshalSendAndReceive("http://localhost:9000/MyServices/ws/soap/MyService", request,new WebServiceMessageCallback() {

        public void doWithMessage(WebServiceMessage message) {
            try {
                    SoapHeader soapHeader = ((SoapMessage) message).getSoapHeader();

                    // create the header element
                    ObjectFactory factory = new ObjectFactory();
                    MYHeader headerType = factory.createMYHeader();
                    Auth authType = new Auth();
                    authType.setMyID("1010");
                    authType.setPwd("myPwd");
                    headerType.setAuth(authType);
                    JAXBElement<MYHeader> headers =
                            factory.createMYHeader(headerType);

                    // create a marshaller
                    JAXBContext context = JAXBContext.newInstance(MYHeader.class);
                    Marshaller marshaller = context.createMarshaller();
                    marshaller.marshal(headers, soapHeader.getResult());
            } catch (Exception e) {
                System.out.println("ERROR : "+e);
            }
        }
    });
    MyResponse response= (MyResponse) myObj;
    return myObj;
}