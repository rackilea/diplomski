@Component
public class ActionSchedulerFactoryBean extends SchedulerFactoryBean {

   @Autowired
   private ScheduledActionRunnerJobDetailFactory jobDetailFactory;

   @Autowired
   private ActionCronTriggerFactoryBean triggerFactory;

   @Override
   public void afterPropertiesSet() throws Exception {
       setJobDetails(jobDetailFactory.getObject());
       setTriggers(triggerFactory.getObject());
       super.afterPropertiesSet();
   }

}