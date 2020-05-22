@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Resender {
    @WebMethod
    void resend(
        @WebParam(name = "start") @XmlJavaTypeAdapter(type = DateTime.class, value = XSDDateTimeMarshaller.class) DateTime start,
        @WebParam(name = "end") @XmlJavaTypeAdapter(type = DateTime.class, value = XSDDateTimeMarshaller.class) DateTime end
    );
}