import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class TestngTestSuite {
    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { ExampleTest.class,ExampleTest2.class });
        testng.addListener(tla);
        testng.run();
    }
}