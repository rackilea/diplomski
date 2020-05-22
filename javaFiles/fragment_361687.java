@Stateless
public class CustomerWSClient {

    @WebServiceRef(wsdlLocation = "/customer.wsdl")
    private CustomerService service;

    public void getCustomer(Integer customerID) throws Exception {
        Customer port = service.getCustomerPort();
        try {
            port.getCustomer(customerID);  
        } catch(Exception e) {
            throw e;
        } finally {
            // Get the HTTP code here!
            int responseCode = (Integer)((BindingProvider) port).getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE);
        }
    }

}