CREATE OR REPLACE AND COMPILE JAVA SOURCE NAMED "LoopingTest" AS 
import java.util.Arrays;
import java.util.List;

public final class LoopingTest {
    public static String greet(final String userName) {
        final List<String> emptyList = Arrays.asList(userName);
        for (final String string : emptyList) {
            System.out.println(string);
        }
        return "Hello " + userName;
    }
}
/

Error report -
ORA-29536: badly formed source: Encountered "final String string :" at line 7, column 14.
Was expecting one of:
    "boolean" ...
...