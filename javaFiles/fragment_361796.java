package com.my.package;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.web.authentication.
    UsernamePasswordAuthenticationFilter;

public class UserPassAuthFilterBeanPostProcessor implements BeanPostProcessor {

    private String usernameParameter;
    private String passwordParameter;

    @Override
    public final Object postProcessAfterInitialization(final Object bean,
        final String beanName) {
        return bean;
    }

    @Override
    public final Object postProcessBeforeInitialization(final Object bean,
        final String beanName) {
        if (bean instanceof UsernamePasswordAuthenticationFilter) {
            final UsernamePasswordAuthenticationFilter filter =
                (UsernamePasswordAuthenticationFilter) bean;
            filter.setUsernameParameter(getUsernameParameter());
            filter.setPasswordParameter(getPasswordParameter());
        }

        return bean;
    }

    public final void setUsernameParameter(final String usernameParameter) {
        this.usernameParameter = usernameParameter;
    }

    public final String getUsernameParameter() {
        return usernameParameter;
    }

    public final void setPasswordParameter(final String passwordParameter) {
        this.passwordParameter = passwordParameter;
    }

    public final String getPasswordParameter() {
        return passwordParameter;
    }

}