package com.backend.configuration;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.backend.repository")
public class MongoConfiguration extends AbstractMongoConfiguration {

  private static final String DB_NAME = "test";

  @Override
  protected String getDatabaseName() {
    return DB_NAME;
  }

  @Override
  @Bean
  public Mongo mongo() {
    return new Fongo(getDatabaseName()).getMongo();
  }

  @Override
  protected String getMappingBasePackage() {
    return "com.backend.domain";
  }
}