package test;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    static int counter = 0;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public BlahService getBlahService() {
        BlahService bean = new BlahService();
        bean.setName("name" + counter++);
        return bean;
    }

    @Bean
    public FooService getFooService () {
        return new FooService();
    }
}