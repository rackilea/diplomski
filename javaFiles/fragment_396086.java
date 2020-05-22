@SuppressStaticInitializationFor(value = "so46196071.Base") // suppress the static in Base (note this is my package name)
@PowerMockIgnore("javax.management.*")
@RunWith(PowerMockRunner.class)
@PrepareForTest({Module.class, ServiceA.class, ServiceB.class})
public class ModuleBisTest {
    private Module module;

    @Mock
    private ServiceA serviceA;

    @Mock
    private ServiceB serviceB;

    @Before
    public void setup() throws Exception {
        // MockitoAnnotations.initMocks(this); /* this is not needed => done by the runner */

        PowerMockito.mockStatic(ServiceA.class);
        PowerMockito.when(ServiceA.class, "getInstance").thenReturn(serviceA);

        PowerMockito.mockStatic(ServiceB.class);
        PowerMockito.when(ServiceB.class, "getInstance").thenReturn(serviceB);

        module = new Module();
        Whitebox.setInternalState(Base.class, "serviceA", serviceA); // set serviceA in Base "by hand"
        Whitebox.setInternalState(Base.class, "serviceB", serviceB); // set serviceB in Base "by hand"
        // I spy it because it has other methods I need to mock
        module = PowerMockito.spy(module);
    }

    // ...