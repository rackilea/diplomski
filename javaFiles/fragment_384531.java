@RestController
public CustomerController {

   @Autowire private CustomerService customerService;   

   @GET("/customer/{custId}")
   public Customer getCustomer(@Param CustomerId custId){
      return customerService.getCustomerById(custId);
   }

}