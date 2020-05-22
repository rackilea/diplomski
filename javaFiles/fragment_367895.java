package markusschultevalue;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;

@Factory
public class SomeFactory {

    private final String name;

    // there are better ways to do this but
    // this is consistent with the code in the
    // question being asked...
    public SomeFactory(@Value("${some.config.value}") String name) {
        this.name = name;
    }

    @Bean
    public SomeWidget createWidget() {
        return new SomeWidget(name);
    }
}