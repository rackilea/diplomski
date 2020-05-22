public interface testService {
@WebMethod(operationName = "myOperations",  action = "")
@WebResult(name = "errorCode",targetNamespace = "")

public String testWebService(
    @WebParam(name = "studentId", targetNamespace = "", mode = Mode.IN) Integer studentId,
    @WebParam(name = "studenName", targetNamespace = "", mode = Mode.IN) String studenName);
    }