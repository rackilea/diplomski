package com.sample.restpayara;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;

@SpringBootApplication
public class RestPayaraApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RestPayaraApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RestPayaraApplication.class);
    }

    @Bean
    public HttpMessageConverters converters() {
        return new HttpMessageConverters(true, Arrays.asList(
                new MappingJackson2HttpMessageConverter(),
                new Jaxb2RootElementHttpMessageConverter())
        );
    }
}