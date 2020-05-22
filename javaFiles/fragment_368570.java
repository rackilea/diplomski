import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class MyWebService {

    @WebMethod
    public String myMethod(){
        return "Hello World";
    }

}