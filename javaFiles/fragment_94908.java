// 0/15 -> Every 15 minutes on the clock
// 17-20 -> Between 5pm and 8pm on the JVM timezone
// if you want timezone specific there is a 'zone' parameter: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/scheduling/annotation/Scheduled.html#zone--
@Scheduled(cron="0 0/15 17-20 * * ?")
public void doSomething() {
    // ..
}