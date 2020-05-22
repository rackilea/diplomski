@Configuration
 @EnableAsync
 @ConditionalOnProperty(name = "async.support.enabled", havingValue = true)
 public class MyAsyncEnablerConfiguration {

 }