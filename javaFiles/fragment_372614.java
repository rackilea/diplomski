@RunWith(MockitoJUnitRunner.class)
public class BTest {

    @InjectMocks
    @Spy
    private FakeB b;

    @Test
    public void testSomething() {
        when(b.convert(any())).thenReturn(something);
    }

    public static class FakeB extends B {
        protected Object convert(Object someobject) {
            return null;
        }  
    }
}