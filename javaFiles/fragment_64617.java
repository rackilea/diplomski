import org.assertj.core.api.Assertions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClassUsingParameters {

    @Parameters({"studentName", "studentAge"})
    @Test
    public void testMethod(String name, int age) {
        Assertions.assertThat(name).isNotEmpty();
        Assertions.assertThat(age).isGreaterThan(0);
    }
}