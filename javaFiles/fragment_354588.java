@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminApplication.class)
@Import(TestConfigForMail.class)
@WebAppConfiguration
public class OrderTest {

    private MockMvc mockMvc;

    @Autowired
    private OrderService orderService;
...