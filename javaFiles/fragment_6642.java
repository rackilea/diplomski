@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BakeryConfig.class)
public class BakeryTest {

    @Autowired
    @Qualifier("iceCream")  // <===================== you must specify which bean to be wired
    Dessert dessert;

    @Autowired
    Taster taster;