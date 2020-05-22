@WebService
public interface Service {

public Address validate(Address address);

@WebMethod
public String sayHi(
    @WebParam(mode = WebParam.Mode.IN)
    String msg);
}