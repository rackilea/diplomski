package com.tarkshala;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationAnnotationExample {

    @Bean
    public AmazonDynamoDBClientBuilder getAmazonDynamoDBClientBuilder() {
        return AmazonDynamoDBClientBuilder.standard().withRegion(Regions.AP_SOUTH_1);
    }

    @Bean
    public DynamoDBMapper getDynamoDBMapper(final AmazonDynamoDBClientBuilder builder) {
        return new DynamoDBMapper(builder.build());
    }
}