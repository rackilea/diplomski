import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;


@MicronautTest(propertySources = "classpath:some-special-test-props.properties")
public class SomeTest {

    @Test
    void someTest() {
        // ...
    }
}