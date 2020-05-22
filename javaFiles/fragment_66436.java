package com.stackoverflow.foo;
@Configuration
public class BaseConfiguration {
   @Bean
   @Lazy
   public BService bService1() {
       return new BService();
   }
}

package com.stackoverflow.bar;
@Configuration
@Import({BaseConfiguration.class})
public class TestConfiguration {
    @Bean
    public BService bService2() {
        return Mockito.mock(BService.class);
    }
}