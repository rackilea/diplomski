@Controller 
public MyController {

    @AutoWired
    private DataService dataService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    private DataGenerator readBookmark(@PathVariable Long customerId, @PathVariable Integer typeId) {
        return dataService.getData(customerId, typeId);
    }
}

@Service
public class DataService {

    @AutoWired
    private JPARepository repository;

    public DataGenerator getData(long customerId, int typeId) {
        Type typeDetails = repository.getType(typeId);
        Customer customerDetails = repository.getCustomer(customerId);
        return new DataGenerator(customerDetails, typeDetails);
    }
}