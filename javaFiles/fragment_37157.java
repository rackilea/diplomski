@RestController
@RequestMapping("/your_decide/")
public class MobilityApi {


    @Autowired
    private MobilityService mobilityService;

    @GetMapping("/mobilityCC")
    public Response retrieveOrderDetails(@RequestParam("orderid") String orderid) {
        return mobilityService.getOrderDetails(orderid);
    }
}