import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MyServiceTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { "A", 200 }, { "B", 404 }, { "C", 200 } 
                 });
    }

    private int valInput;

    private String responseCodeOutput;

    private Foo foo = ...;

    public MyServiceTest(String valInput, int responseCodeOutput) {
        this.valInput = valInput;
        this.responseCodeOutput = responseCodeOutput;
    }

    @Test
    public void doThings() {     
        when(foo.getVal()).thenReturnEach(valInput);
        String response = myService.doThings(foo);
        Assert.assertEqual(responseCodeOutput, response);
    }
}