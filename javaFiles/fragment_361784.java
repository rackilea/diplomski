@Controller
public class MyController {

    @Resource
    private BillingService billingService;

    @RequestMapping(value = "/registration")
    public String sendToRegistrationPage() throws ServiceException {
        GoogleTransaction googleTransaction = new GoogleTransaction(0, "aei", new Date(), TransactionStatus.NEW, BigDecimal.ZERO, "", "", 0, "");
        billingService.registerTransaction(googleTransaction);
        return "registration";
    }
}