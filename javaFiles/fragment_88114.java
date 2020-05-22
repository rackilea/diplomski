@RunWith(SpringRunner.class)
@SpringBootTest
public class MyServiceTest {
    @Autowired    
    private MyService service;

    @Test
    public void testFoo() {
        String expResult = "";
        String result = service.foo();
        assertEquals(expResult, result);
    }
}