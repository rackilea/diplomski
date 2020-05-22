@RunWith(PowerMockRunner.class)
@PrepareForTest(Class1.class)
public class Class1Test {
    private Class1 testSubject;

    @Mock 
    private Class2 class2;

    @Test
    public void testMethod1() throws Exception {
        testSubject.method1();
        verify(class2).method2();
    }

    @Before 
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        PowerMockito.whenNew(Class2.class).withNoArguments().thenReturn(class2);
        testSubject = new Class1();
    }
}