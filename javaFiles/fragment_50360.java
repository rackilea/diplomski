CREATE OR REPLACE AND COMPILE JAVA SOURCE NAMED "LoopingTest" AS 
import java.util.Arrays;
import java.util.List;

public final class LoopingTest {
    public static String greet(final String userName) {
        final List<String> emptyList = Arrays.asList(userName);
        // remove 'final' to avoid ORA-29536
        // for (final String string : emptyList) {
        for (String string : emptyList) {
            System.out.println(string);
        }
        return "Hello " + userName;
    }
}
/

Java source LoopingTest compiled