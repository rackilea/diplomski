@Endpoint
public class AServer
{
    private final static String NAMESPACE_URI = "http://some.namespace/v3/idk/am/i/even/real";
    private final static String LOCALPART = "XMLElementName";
    private final SomeMarshaller marshaller;

    @Autowired
    public EventServer(EventReceiveMarshaller marshaller) 
    {
        // I use a marshaller class to simplify my life
        this.marshaller = marshaller; 
    }

    @Override
    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = LOCALPART)
    public JAXBElement<SomeResponseMessageType> triggerResponse(@RequestPayload JAXBElement<SomeRequestMessageType> msg) {

        // do something with the `msg` request

        // Send a OK response
        return this.marshaller.createReply(msg);
    }
}