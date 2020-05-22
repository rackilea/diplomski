@Service
public class OrderService {

   @Autowire private CustomerService customerService;

   public void placeOrder(Order order, CustomerId custId) {
      Customer customer = customerServive.getCustomerById(custId);
      //your code here
   }
}