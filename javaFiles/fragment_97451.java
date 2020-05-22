@RunWith(Suite.class)
@Suite.SuiteClasses({
MyUnitTests.class
})
public class MySuiteTest {

@ClassRule
public static H2TestRule h2TestRule = new H2TestRule();

}