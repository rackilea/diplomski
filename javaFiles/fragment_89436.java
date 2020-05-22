import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.BeforeClass;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({MyTest1.class, MyTest2.class, MyTest3.class})
public class MyTestSuite {

    @BeforeClass
    public static void setUp() {
        System.out.println("setting up");
    }
}