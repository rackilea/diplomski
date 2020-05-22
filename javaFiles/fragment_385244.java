import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ClassToBeTestedTest {

    @Test
    public void test() {
        ClassToBeTested c = new ClassToBeTested();
        c.createRootElement();
        assertTrue(c.rootElementExists());
    }

}