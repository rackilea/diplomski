@RunWith(MockitoJUnitRunner.class)
public class ATest {

    @InjectMocks
    A a;

    @Mock //or @Spy
    B b;

    @Mock //or @Spy
    C c;

    @Test
    public void test() {
        a.method();
    }
}