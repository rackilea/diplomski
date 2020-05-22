@RunWith(PowerMockRunner.class)
@PrepareForTest(BaseConfigurable.class)
public class ConfigReferenceProcessorTest {

    // public class so the constructor is callable
    public static class MockConfigurable extends BaseConfigurable {
        // Mandatory methods
    }

    @Mock
    private ConfigReferenceCfg configRefCfg;
    @Mock
    private ConfigurableFactory configurableFactory;
    @Mock
    private MockConfigurable mockConfigurable;
    @InjectMocks
    private ConfigReferenceProcessor processorUT;

    @Test
    public void shouldProcessConfigRef() throws Exception {
        final String className = MockConfigurable.class.getName();
        given(configRefCfg.getClassName()).willReturn(className);
        given(configRefCfg.getConfigName()).willReturn("testName");
        given(configurableFactory.newConfigurable(MockConfigurable.class, className)).
            willReturn(mockConfigurable);
        MockConfigurable result =
                processorUT.processConfigReference(MockConfigurable.class, configRefCfg);
        assertThat(result, is(mockConfigurable));
        verify(mockConfigurable).loadConfig("testName");
    }
}