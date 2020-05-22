@Component
public class CurrencyUtil {

    private LocalizationHelper helper;

    private NumberFormatter numberFormatter;

    @Autowired
    public CurrencyFormatter(LocalizationHelper helper, NumberFormatter numberFormatter) {
        this.helper = helper;
        this.numberFormatter = numberFormatter;
    }

    public String prettyPrint(Currency amount) {
        // ...
    }
}