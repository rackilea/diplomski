@Component
public class CurrencyUtil {

    private final NumberFormatter numberFormatter;

    @Autowired
    public CurrencyFormatter(NumberFormatter numberFormatter) {
        this.numberFormatter = numberFormatter;
    }

    public String prettyPrint(Currency amount) {
        // ...
    }
}