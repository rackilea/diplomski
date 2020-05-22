package org.examples.spring.boot.caching;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@SpringBootApplication
@EnableCaching
public class ConcurrentMapCachingExample implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(ConcurrentMapCachingExample.class, args);
  }

  @Autowired
  private ExampleCacheableService exampleService;

  @Override
  public void run(String... args) throws Exception {
    assertThat(exampleService.isCacheMiss()).isFalse();
    assertThat(exampleService.computeValue("one").intValue()).isEqualTo(1);
    assertThat(exampleService.isCacheMiss()).isTrue();
    assertThat(exampleService.computeValue("one").intValue()).isEqualTo(1);
    assertThat(exampleService.isCacheMiss()).isFalse();
  }  
}

@Service
class ExampleCacheableService {

  boolean cacheMiss;

  boolean isCacheMiss() {
    boolean cacheMiss = this.cacheMiss;
    this.cacheMiss = false;
    return cacheMiss;
  }

  @Cacheable("Example")
  public Short computeValue(String cacheKey) {
    System.out.printf("Computing value for [%s]%n", cacheKey);
    cacheMiss = true;
    return 1;
  }
}