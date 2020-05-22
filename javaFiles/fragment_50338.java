@Component
public class ScheduledActionRunnerJobDetailFactory extends JobDetailFactoryBean {

    @Autowired
    private ScheduleService scheduleService;

    @Override
    public void afterPropertiesSet() {
       setJobClass(ScheduledActionRunner.class);
       Map<String, Object> data = new HashMap<String, Object>();
       data.put("scheduleService", scheduleService);
       setJobDataAsMap(data);
       super.afterPropertiesSet();
   }
}