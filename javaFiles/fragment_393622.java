@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private static myDb dbh = null;
    private static Context context = null;
    private static Integer n = 100;

    @BeforeClass
    public static void setUp() throws Exception {
        context = InstrumentationRegistry.getTargetContext();
        dbh = myDb.getDatabase(context);
    }

    @Before
    public void clear() throws Exception {
        dbh.daoCurrency().clearCurrencies();
        dbh.daoCurrencyPair().clearCurrencyPairs();
    }



    public void createCurrencies() {
        Integer n=100;

        for (Integer i=1; i<=n; i++)
        {
            Currency c = new Currency();
            c.setCode("CUR"+i);

            dbh.daoCurrency().addCurrencies(c);
        }

    }

    public void createCurrencyPairs() {

        List<Currency> currencyList = dbh.daoCurrency().getCurrencies();

        for (Currency c1 : currencyList)
        {
            for (Currency c2 : currencyList)
            {
                CurrencyPair cp = new CurrencyPair();
                cp.setBaseId(c1.getId());
                cp.setCounterId(c2.getId());

                dbh.daoCurrencyPair().addCurrencyPairs(cp);
            }

        }

    }

    @Test
    public void testCurrencies() {

        createCurrencies();

        List<Currency> currencyList = dbh.daoCurrency().getCurrencies();
        assertEquals((Integer) n, (Integer) currencyList.size());
    }

    @Test
    public void testCurrencyPairs() {

        createCurrencies();
        createCurrencyPairs();

        List<CurrencyPair> currencypairList = dbh.daoCurrencyPair().getCurrencyPairs();
        assertEquals((Integer) (n*n), (Integer) currencypairList.size());
    }

    @AfterClass
    public static void tearDown() throws Exception {
        dbh.close();
    }
}