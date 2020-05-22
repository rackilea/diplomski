package markusschultevalue;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

// This will load the config value
// from src/test/resources/some-widget-test-config.yml
@MicronautTest(propertySources = "classpath:some-widget-test-config.yml")
public class ConfigFileTest {

    @Inject
    SomeWidget someWidget;

    @Test
    void testWidget() {
        assertEquals("Some Other Widget Name", someWidget.getName());
    }
}