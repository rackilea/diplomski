@RestController
public class OrderController {

    @Autowired
    @Qualifier("carSvc")
    DAOService carSvc;

    @Autowired
    @Qualifier("orderSvc")
    DAOService orderSvc;

}