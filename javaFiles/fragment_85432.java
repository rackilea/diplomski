@Component
public class SchedulerServiceImpl implements SchedulerService {

        private static final Logger logger = LoggerFactory.getLogger(SchedulerServiceImpl.class);

        @Autowired
        @Qualifier(value="infScheduler")
        private TaskScheduler taskScheduler;

        @Autowired
        private MyService myService;

        private ScheduledFuture job1;//for other jobs you can add new private state variables

        //Call this on deployment from the ScheduleDataRepository and everytime when schedule data changes.
        @Override
        public synchronized void scheduleJob(int jobNr, long newRate) {//you are free to change/add new scheduling data, but suppose for now you only want to change the rate
                if (jobNr == 1) {//instead of if/else you could use a map with all job data
                        if (job1 != null) {//job was already scheduled, we have to cancel it
                                job1.cancel(true);
                        }
                        //reschedule the same method with a new rate
                        job1 = taskScheduler.scheduleAtFixedRate(new ScheduledMethodRunnable(myService, "methodInMyServiceToReschedule"), newRate);
                }
        }
}