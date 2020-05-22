@WebService(name = "departmentServiceSOAP", targetNamespace = "/namespace")
@javax.jws.soap.SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface DepartmentService {
    @WebMethod
    public Department getDepartment(Long id);
}