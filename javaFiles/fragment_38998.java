@RestController
public class WalletController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/generateAddress", method = RequestMethod.POST)
    public ResponseEntity<String> generateAddress(@RequestParam("walletName") String walletName,
                                                  @RequestParam("currencyName") String currencyName, HttpServletRequest request) {
        logger.info("walletName {} and currencyName {}", walletName, currencyName);
        String wallet_Name = request.getParameter("walletName");
        String currency_Name = request.getParameter("currencyName");
        logger.info("walletName {} and currencyName {}", wallet_Name, currency_Name);

        // DO other Stuff
        return ResponseEntity.ok(null);
    }
}