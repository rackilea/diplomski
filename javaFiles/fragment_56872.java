import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class MyJob {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    public Step fileValidationStep() {
        return steps.get("fileValidationStep")
                .tasklet((contribution, chunkContext) -> {
                    // TODO add code to check if the file exists
                    System.out.println("file not found");
                    chunkContext.getStepContext().getStepExecution().setTerminateOnly();
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step fileProcessingStep() {
        return steps.get("fileProcessingStep")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("processing file");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Job job() {
        return jobs.get("job")
                .start(fileValidationStep())
                .next(fileProcessingStep())
                .build();
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyJob.class);
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean(Job.class);
        JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
        System.out.println("Job status: " + jobExecution.getExitStatus().getExitCode());
    }

}