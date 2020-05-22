import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class ParseTest {

    private String parseValue;

    public ParseTest(String parseValue) {
        this.parseValue = parseValue;
    }

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { "[1 2]" }, { "[1,2,]" } };
        return Arrays.asList(data);
    }

    @Test(expected = ParseException.class)
    public void testParseFailure1() throws Exception {
        Parse.parse(parseValue);
    }

}