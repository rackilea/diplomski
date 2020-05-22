@SpringBootTest
@RunWith(SpringRunner.class)
public class MyServiceTest {

    @Autowired
    private MyService myService;

    @Test
    public void callEndpoint() {
        myService.callEndpoint();
    }
}