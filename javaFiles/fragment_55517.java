@RunWith(PowerMockRunner.class)
@PrepareForTest({MyClass.class})
public class FirstTest {
    MyClass mockMyClass;

    @Test
    public void setUp(){
        mockMyClass = mock(MyClass.class);
    }
}