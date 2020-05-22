@RunWith(Suite.class)
@Suite.SuiteClasses({ DataServiceTest.class, OtherTest.class })
public class AllTests {
// empty
}


public class DataServiceTest {  // no extends here
@BeforeClass
static void onceExecutedBeforeAll() {
    println(" Print before Start Test Cases");
}
@Test
public void testSample(){
    println(" Inside Sample");
}
}