import io.micronaut.context.annotation.Property;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

@MicronautTest
@Property(name="some.config.value", value = "My Test Value")
public class SomeTest {


    @Test
    void someTest() {
        // ...
    }
}