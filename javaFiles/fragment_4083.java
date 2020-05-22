public class ATest {

    @Autowired
    A a;

    @Mock
    B b;

    @Test
    public void test() {
        a.setB(b);
        a.method();
    }
}