@WebService(targetNamespace="http://package/", name="ServiceX", portName="ServiceXPort", serviceName="ServiceName")
public class ServiceX extends ServiceXBase {

    public ServiceX(IFacade facade) {
         super(facade);
    }

    @WebMethod
    public Result getResult(){
        return super.getResult();
    }
}