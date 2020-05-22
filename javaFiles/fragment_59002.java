import org.testng.annotations.Test;
import static org.testng.Assert.*;

class ExampleTest {
    Example authManager = new Example();

    @Test(groups = "integration")
    public void testHelloWorld() {
        String helloWorld = authManager.helloWorld();
        assertEquals(helloWorld, "hello");
    }
}