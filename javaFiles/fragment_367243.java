package com.stackoverflow.spring.boot.async;


import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter implements EmbeddedServletContainerCustomizer
{
  public void customize(final ConfigurableEmbeddedServletContainer container) {}
}