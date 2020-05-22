@WebService(serviceName = "NewWebService")
@Local
@Stateless
public class IServiceJAXImpl implements IServiceJAX {

    @WebMethod(operationName = "hello")
    @Override
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}