@RunWith(Parameterized.class)
public class TestCase {
    private Type placeholder1;
    private Type placeholder2;
    ...
    public TestCase(Param1 placeholder1, Param2 placeholder2, ...) {
        this.placeholder1 = placeholder1;
    }

    @Parameters
    public static Collection<Object[][]> data() {
        //prepare data
        //each row is one test, each object in row is placeholder1/2... for this test case 
    }

    @Test
    public void yourTest() {...}
}