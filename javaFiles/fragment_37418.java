public class TestOutInterceptor extends AbstractSoapInterceptor {
    private static Logger logger = LoggerFactory
        .getLogger(EnterpriseServiceMonitoringOutInterceptor.class);
    private SAAJOutInterceptor saajOut = new SAAJOutInterceptor();




    public TestOutInterceptor() {
    super(Phase.PRE_PROTOCOL);
    getAfter().add(SAAJOutInterceptor.class.getName());
    // TODO Auto-generated constructor stub
    }

    @Override
    public void handleMessage(SoapMessage soapMessage) throws Fault {
    getSOAPMessage(soapMessage);
        //add the ending interceptor to do the work
    soapMessage.getInterceptorChain().add(new EndingInterceptor());
    }



    private SOAPMessage getSOAPMessage(SoapMessage smsg){

        SOAPMessage soapMessage = smsg.getContent(SOAPMessage.class);

    if (soapMessage == null) {



        saajOut.handleMessage(smsg);

        soapMessage = smsg.getContent(SOAPMessage.class);

    }   

    return soapMessage;

  }

    static class EndingInterceptor extends AbstractSoapInterceptor {

    private SAAJOutEndingInterceptor saajOutEnding = new SAAJOutEndingInterceptor();
        public EndingInterceptor() {
             super(Phase.PRE_PROTOCOL_ENDING);
             addBefore(SAAJOutEndingInterceptor.class.getName()); 
         }
        public void handleMessage(SoapMessage soapMessage) throws Fault { 
            ServiceData serviceData=(ServiceData) soapMessage.getExchange().remove("esmServiceData");
        System.out.println("Test");
        System.out.println(soapMessage.getInterceptorChain());

        SOAPMessage soapMessagexml = getSOAPMessage(soapMessage);
        if(serviceData!=null){
            serviceData.setResponseTime(new BigDecimal((new Date()).getTime()));

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
            soapMessagexml.writeTo(out);
            String strMsg = new String(out.toByteArray());
             serviceData.setResponsePayload(strMsg);
             logger.debug(strMsg);
            } catch (SOAPException e) {
            logger.error("", e);
            } catch (IOException e) {
            logger.error("", e);
            }

        }
        }

        private SOAPMessage getSOAPMessage(SoapMessage smsg){

            SOAPMessage soapMessage = smsg.getContent(SOAPMessage.class);

        if (soapMessage == null) {



            saajOutEnding .handleMessage(smsg);

            soapMessage = smsg.getContent(SOAPMessage.class);

        }   

        return soapMessage;

      }
   } 

}