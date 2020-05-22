@ContextConfiguration(classes=Config.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ATest {

    @Autowired
    A a;

    @Mock
    B b;

    @Test
    public void test() {
        ReflectionTestUtils.setField(a, "b", b);
        a.method();
    }
}