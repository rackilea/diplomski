@RunWith(MockitoJUnitRunner.class)
public class ATest {
    @Mock
    private B b;

    private A a;

    @Before
    public void setup() {
        a = new A(Optional.of(b));
    }
}