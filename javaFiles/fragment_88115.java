public class MyServiceTest2 {
    private MyService service;

    @Before
    public void setUp() {
        service = new MyService(new AnotherService.Fake());
    }

    @Test
    public void testFoo() {
        String expResult = "";
        String result = service.foo();
        assertEquals(expResult, result);
    }
}