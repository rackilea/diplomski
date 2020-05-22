package sample;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("playground")
public class Bar extends Base {
    private String barProperty;

    public String getBarProperty() {
        return barProperty;
    }

    public void setBarProperty(String barProperty) {
        this.barProperty = barProperty;
    }
}