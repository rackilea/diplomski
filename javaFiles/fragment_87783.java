@RunWith(SpringJUnit4ClassRunner.class)
public class PriceWatchTest {

    @Autowired
    private PriceWatchService priceWatchService:

    @Test
    public static void hasPriceWatchItems() {
        List<PriceWatch> priceWatchList = priceWatchService.findAll();
    }

}