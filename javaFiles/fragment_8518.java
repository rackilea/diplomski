import org.jglue.cdiunit.CdiRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;


@RunWith(CdiRunner.class)
public class FooBarTest {

    private ExpectedException thrown = ExpectedException.none();

    @Rule
    public ExpectedException getThrown() {
        return thrown;
    }

    @Test
    public void test() {
        thrown.expect(ArithmeticException.class);
        int i = 1 / 0;
    }
}