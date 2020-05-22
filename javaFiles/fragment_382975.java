@RunWith(SpringRunner.class)
@TestPropertySource("/test.properties")
@EnableConfigurationProperties(VehicleSequenceConfigurationProperties.class)
public class VehicleSequenceConfigurationPropertiesTest {

    @Autowired
    private VehicleSequenceConfigurationProperties vehicleSequenceConfigurationProperties;

    @Test
    public void checkPropagationTreeMaxSize() {
        assertThat(vehicleSequenceConfigurationProperties.getPropagationTreeMaxSize()).isEqualTo(10000);
    }
}