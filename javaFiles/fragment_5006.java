@RunWith(Parameterized.class)
public class RunTenTimes {

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[10][0];
    }

    public RunTenTimes() {
    }

    @Test
    public void runsTenTimes() {
        System.out.println("run");
    }
}