@Scheduled(cron = "0 */1 * * * ?")
public checkSchedules() {
...
CronExpression cronExpression = new CronExpression(cronExpressionStringFromDB);
  if (cronExpression.isSatisfiedBy(new Date())) {
     //run stuff
  } 
}