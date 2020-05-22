@RunWith(MockitoJUnitRunner.class)
public class SampleServiceTest {

    @InjectMocks
    private SampleService sample;

    @Mock
    private Logger securityLogger;

    @Test
    public void testDoSomething() {
        doThrow(new RuntimeException("Fail")).when(securityLogger).log(anyString());

        sample.doSomething(); // will fail 
    }

}