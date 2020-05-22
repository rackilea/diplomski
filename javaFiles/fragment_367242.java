package com.stackoverflow.spring.boot.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

@Import(WebConfig.class)
@SpringBootApplication
public class WebMain {
  private final SpringApplication application;

  public WebMain() {
    final SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder(WebMain.class);
    application = applicationBuilder.build();
  }

  public SpringApplication getApplication() { return application; }

  public static void main(final String[] args) {
    new WebMain().getApplication().run(args);
  }
}