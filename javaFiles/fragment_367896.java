package markusschultevalue;

import io.micronaut.context.annotation.Property;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
@Property(name="some.config.value", value="Some Widget Name")
public class PropertyAnnotationTest {

    @Inject
    SomeWidget someWidget;

    @Test
    void testWidget() {
        assertEquals("Some Widget Name", someWidget.getName());
    }
}