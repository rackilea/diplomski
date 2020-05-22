package sample;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleConfiguration {

    @Bean
    @ConfigurationProperties("playground")
    @ConditionalOnProperty("playground.foo-property")
    public Foo foo() {
        return new Foo();
    }

    @Bean
    @ConfigurationProperties("playground")
    @ConditionalOnProperty("playground.bar-property")
    public Bar bar() {
        return new Bar();
    }

    @Bean
    @ConfigurationProperties("playground")
    @ConditionalOnProperty("playground.shared-property")
    @ConditionalOnMissingBean(Base.class)
    public Base base() {
        return new Base();
    }
}