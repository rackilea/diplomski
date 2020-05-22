@Configuration
@EnableScheduling
public class AppConfig
{
  @Scheduled(cron="0 55 23 * * ?")
  public void doSomething() {
      // something that should execute every night at 23:55
  }
}