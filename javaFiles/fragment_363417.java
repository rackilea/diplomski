@RunWith(Suite.class)
@SuiteClasses({ Test1.class, Test2.class})
public class SuiteWithTimeout {
    @ClassRule
    public static Timeout timeout = new Timeout(1000);
}