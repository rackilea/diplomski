@RunWith(JMockit.class)
public class ServiceTest {

    @Tested
    private Service myService;

    @Injectable
    private AnotherService mockAnotherService;

    @Test
    public void methodTest() {
        new Expectations() {{
           mockAnotherService.someMethod("someValue"); result = true;
       }};

        assertTrue(myService.someMethod());
    }
}