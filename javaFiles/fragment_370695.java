@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderInfoServiceImplTest {
    // autowire class under test
    @Autowired
    private OrderInfoService orderInfoService;

    @Test
    public void testGetOrderInfo() {
        System.out.println("Test - getOrderInfo");

        String res = "[OrderInfo :typeNameca1121a - retroFit ]" ;   
        List<OrderInfo> orderInfo = orderInfoService.getOrderInfo("ca1121a");
        System.out.println("Created output orderInfo");

        System.out.println("\t" + orderInfo.size());

        Assert.assertEquals(res, orderInfo.get(0).toString());
    }
}