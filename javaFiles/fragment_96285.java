@RunWith(value = BlockJUnit4ClassRunner.class)
public class Test extends TestCase{

    @Test(expected = IllegalArgumentException.class)
    public void test1() throws Throwable{
        assertFalse(throwException());
    }

    private boolean throwException(){
        throw new IllegalArgumentException();
    }
}