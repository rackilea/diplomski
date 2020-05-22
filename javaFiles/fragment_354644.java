import org.junit.runner.JUnitCore;
import com.example.tests;

public static void main(String[] args) {
    Result result = JUnitCore.runClasses(Test.class);
    for (Failure failure : result.getFailures()) {
        System.out.println(failure.toString());
    }
}