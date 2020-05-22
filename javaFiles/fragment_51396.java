@RunWith(Parameterized.class)
public class Testing {
    private final static String constantValue = "myConstant";

    @Parameters
    public static Object[][] params() { 
         return new Object[][]{ 
                new Object[] { "item0", 0 },
                new Object[] { "item1", 1 },
                //...
         };
    }

    @Param(0)
    public String arrayValue;

    @Param(1)
    public int arrayIndex;

    @Test
    public void test_arrayValue() {
        assertEquals("array" + arrayIndex + " is true", true, method(arrayValue, constantValue));
    }
}