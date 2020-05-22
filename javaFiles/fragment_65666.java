@RunWith(JUnitParamsRunner.class)
public class MyParameterizedTest extends EnclosedBase {

    @Parameters({"NY", 
                 "CA" })
    @Test
    public void verifyStateTest(String state) {
        nonStaticMethod();
    }
}