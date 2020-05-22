@WebMethod(operationName = "sendSingle2")
@WebResult(name = "sendSingle2Response", targetNamespace = "http://your.namespace.com")
public MyResult sendSingle2(@WebParam(name = "sendSingle2Request") MyRequest request)
{
   ...
}