@Service
public class JobSchedulerService implements SchedulingConfigurer {
    @Autowired
    JobsConfigRepository jobsConfigRepository;

    @Autowired
    List<JobInterface> allJobs;