@RestController
public class CustomerController {
    //@Autowired CustomerService customerService;

    @RequestMapping(path="/customers", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Customer postCustomer(@RequestBody Customer customer){
        //return customerService.createCustomer(customer);
    }
}