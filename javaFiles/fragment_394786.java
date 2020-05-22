@RunWith(MockitoJUnitRunner.class)
    public class GatewayServiceImplTest {

        @Mock
        private GatewayRepository gatewayRepository;

        @InjectMocks
        private GatewayServiceImpl gatewayService;

        @Test
        public void create() {
            val gateway = GatewayFactory.create(10);
            when(gatewayRepository.save(gateway)).thenReturn(gateway);
            gatewayService.create(gateway);
        }
    }