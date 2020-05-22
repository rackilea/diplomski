import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;


@RunWith(Parameterized.class)
public class Foo {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Parameter
    public Class<?> input;

    /**
     * Test of isCompramised method, of class MyClass.
     */
    @Test
    public void testIsCompramised() {
        this.expectedException.expect(IllegalArgumentException.class);
        final MyClass instance = new MyClass();
        instance.isCompramised(input);
    }

    @Parameters(name = "test for {0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { {null}, {Object.class} });
    }
}