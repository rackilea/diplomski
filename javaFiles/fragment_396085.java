@PowerMockIgnore("javax.management.*")
@RunWith(PowerMockRunner.class)
@PrepareForTest({Module.class, ServiceA.class, ServiceB.class})
public class ModuleTest {
    private Module module;

    private static ServiceA serviceA = Mockito.mock(ServiceA.class);

    private static ServiceB serviceB = Mockito.mock(ServiceB.class);

    @BeforeClass
    public static void oneTimeSetup() throws Exception {
        PowerMockito.mockStatic(ServiceA.class);
        PowerMockito.when(ServiceA.class, "getInstance").thenReturn(serviceA);

        PowerMockito.mockStatic(ServiceB.class);
        PowerMockito.when(ServiceB.class, "getInstance").thenReturn(serviceB);
    }

    @Before
    public void setup() throws Exception {
        module = new Module();
        // I spy it because it has other methods I need to mock
        module = PowerMockito.spy(module);
    }

    @Test
    public void methodATest() {
        DataA dataA = new DataA();
        Mockito.when(serviceA.getDataA()).thenReturn(dataA);
        DataA data = module.methodA();
        assertEquals(dataA, data);
    }
    @Test
    public void methodBTest() {
        DataB dataB = new DataB();
        Mockito.when(serviceB.getDataB()).thenReturn(dataB);
        DataB data = module.methodB();
        assertEquals(dataB, data);
    }
}