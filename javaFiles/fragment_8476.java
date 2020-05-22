package cruft;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Michael
 * Creation date 3/24/2018.
 * @link https://stackoverflow.com/questions/49465133/junit-no-runnable-methods?noredirect=1#49465133
 */
public class ClassToTestTest {

    @Test
    public void testPrintMessage() {
        // setup
        String message = "Hello World";
        ClassToTest classToTest = new ClassToTest(message);
        // exercise
        // assert
        Assert.assertEquals(message,classToTest.printMessage());
    }
}