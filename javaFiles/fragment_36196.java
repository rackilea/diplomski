import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.Assertion;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class SystemExitTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void noSystemExit() {
        //passes
    }

    @Test
    public void executeSomeCodeAFTERsystemExit() {
        System.out.println("This is executed before everything.");
        exit.expectSystemExit();
        exit.checkAssertionAfterwards(new Assertion() {
            @Override
            public void checkAssertion() throws Exception {
                System.out.println("This is executed AFTER System.exit()"+
                " and, if exists, the @org.junit.After annotated method!");
            }
        });
        System.out.println("This is executed right before System.exit().");
        System.exit(0);
        System.out.println("This is NEVER executed.");
    }

    @Test
    public void systemExitWithArbitraryStatusCode() {
        exit.expectSystemExit();
        System.exit(0);
    }

    @Test
    public void systemExitWithSelectedStatusCode0() {
        exit.expectSystemExitWithStatus(0);
        System.exit(0);
    }

    @Test
    public void failSystemExit() {
        exit.expectSystemExit();
        //System.exit(0);
    }

}