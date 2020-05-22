@Service
public class CustomerServiceGateway implements CustomerService {

  @Autowire private RestTemplate restTemplate;

  Order getCustomerById(CustomerId custId) {
     return restTemplate.getForObject("http://customer-api/customer/{custId}", custId);
  }
}