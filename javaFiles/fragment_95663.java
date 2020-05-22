@Service
public class JobHistoryService {

    private final JobHistoryRepository jobHistoryRepository;

    public JobHistoryService (final JobHistoryRepository jobHistoryRepository)
    {
        this.jobHistoryRepository = jobHistoryRepository;
    }

    public void setReadyJob(String jobId, String tenant, String idTrigger) {
    JobHistory jobHistory = new JobHistory();
     jobHistory.setJobName(jobId);
     jobHistory.setJobGroup(tenant);
     jobHistory.setIdTrigger(idTrigger);
     jobHistory.setIdUser("12345");
     jobHistory.setState("Ready");
     jobHistory.setDateCreation(new Date());

     jobHistoryRepository.save(jobHistory);
    }