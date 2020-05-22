@Controller
public class JobController {

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private ApplicationContext context;

    @ResponseBody
    @RequestMapping("/job/create/daily")
    public String dailyJob() throws SchedulerException {
        JobDetail jobDetail = context.getBean(JobDetail.class);
        Trigger cronTrigger = context.getBean(Trigger.class, "30 * * ? * MON-FRI");

        scheduler.scheduleJob(jobDetail, cronTrigger);

        return "dailyJob";
    }
}