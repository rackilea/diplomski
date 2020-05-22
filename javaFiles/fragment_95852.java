@RequestWrapper(targetNamespace="http://you.com/ws/types", className="com.you.YourWrapper") 
@WebMethod(operationName = "getCustomers")
@WebResult(name = "customer")
public Customer[] getCustomers(@WebParam(name = "company") String company,
       @WebParam(name = "limitTop") int limitTop){

       //Logic of getting customer be here

}