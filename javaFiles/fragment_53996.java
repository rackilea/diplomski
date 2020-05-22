@RestController
public class MyController{
    // Usually given by Spring Batch
    private JobLauncher jobLauncher;
    // Your Job
    private Job job;
    // Ctor
    public MyController(JobLauncher jobLauncher, Job job, ...){}

    @PostMapping("/")
    public String launchJob(...){
        ...
        // Create JobParameters and launch
        JobParameters jobparameters = new Job Parameters();
        jobLauncher.run(job, jobParameters);
        ...
    }
}