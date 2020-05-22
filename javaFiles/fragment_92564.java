import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarpTest {
    public static void main(String[] args) {
        new CarpTest().run();
    }

    public void run() {
        methodThatCarps();
    }

    private void methodThatCarps() {
        carp("Message");
    }

    private void carp(String message) {
        RuntimeException e = new RuntimeException(message);
        e.fillInStackTrace();
        List<StackTraceElement> stack = new ArrayList<StackTraceElement>(Arrays.asList(e.getStackTrace()));
        stack.remove(0);
        e.setStackTrace(stack.toArray(new StackTraceElement[stack.size()]));
        throw e;
    }
}