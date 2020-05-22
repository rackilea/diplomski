@Component
public class ActionCronTriggerFactoryBean extends CronTriggerFactoryBean {

   @Autowired
   private ScheduledActionRunnerJobDetailFactory jobDetailFactory;

   @Value("${cron.pattern}")
   private String pattern;

   @Override
   public void afterPropertiesSet() throws ParseException {
       setCronExpression(pattern);
       setJobDetail(jobDetailFactory.getObject());
       super.afterPropertiesSet();
   }

}