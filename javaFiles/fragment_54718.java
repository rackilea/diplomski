@XmlRootElement(name = "SrvPutBusinessOperationEventNf")
public class BusinessOperationEvent
{
    @XmlElement(name = "RqUID")
    private String rqUID;
    @XmlElement(name = "RqTm")
    private String rqTm;
    @XmlElement(name = "sPName")
    private String sPName;
    @XmlElement(name = "SystemId")
    private String systemId;
    @XmlElement(name = "Method")
    private String method;
    @XmlElement(name = "Message")
    Message message


}
public class Message
{
    @XmlElement(name = "Event")
    Event event;
}