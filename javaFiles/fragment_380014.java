@RunWith(SpringRunner.class)
@SpringBootTest(classes = { FeatureConfigTest.TestConfiguration class })
public class FeatureConfigTest {
    @Autowired
    private FeatureConfig featureConfig;

    @Test
    public void testgetFeatureUrl() {
        String expected ="featureUrl";
        assertEquals(expected,featureConfig.getFeatureUrl());
    }

    @EnableConfigurationProperties(FeatureConfig.class)
    public static class TestConfiguration {
    }
}