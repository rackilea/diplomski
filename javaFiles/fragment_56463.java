@Endpoint
public class SampleEndpoint
{
    private static final Logger logger = LoggerFactory.getLogger(SampleEndpoint.class.getName());
    private static final String NAME_SPACE_URI = "http://www.example.org/SpringSample/";

    @PayloadRoot(namespace = NAME_SPACE_URI, localPart="requestImplementation")
    @ResponsePayload
    public JAXBElement<AbstractResponse> operationOneResp(@RequestPayload JAXBElement<AbstractRequest> ar)
    {
        if( logger.isDebugEnabled() )
        {
            logger.debug("Operation 1 request "+ar.getValue().getReqName());
        }
        ObjectFactory of = new ObjectFactory();
        AbstractResponse aResp = of.createAbstractResponse();
        aResp.setResponseName("operation 1 response");
        JAXBElement<AbstractResponse> result = of.createResponseImplementation(aResp);
        return result;
    }
    @PayloadRoot(namespace = NAME_SPACE_URI, localPart="requestImplementation2")
    @ResponsePayload
    public JAXBElement<AbstractResponse> operationTwoResp(@RequestPayload JAXBElement<AbstractRequest> ar)
    {
        if( logger.isDebugEnabled() )
        {
            logger.debug("Operation 2 request "+ar.getValue().getReqName());
        }
        ObjectFactory of = new ObjectFactory();
        AbstractResponse aResp = of.createAbstractResponse();
        aResp.setResponseName("operation 2 response");
        JAXBElement<AbstractResponse> result = of.createResponseImplementation(aResp);
        return result;
    }
}