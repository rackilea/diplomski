package sample;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("playground")
public class Foo extends Base {
    private String fooProperty;

    public String getFooProperty() {
        return fooProperty;
    }

    public void setFooProperty(String fooProperty) {
        this.fooProperty = fooProperty;
    }
}