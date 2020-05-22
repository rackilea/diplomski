@RunWith(PowerMockRunner.class)
@PrepareForTest(MyClass.class)
public class MyClassTest {
    private MyClass myClass;

    @Before
    public void setup() {
        myClass = PowerMockito.spy(new MyClass());
        PowerMockito.doNothing().when(myClass, "myPrivateMethod");
    }
    //Tests..
}