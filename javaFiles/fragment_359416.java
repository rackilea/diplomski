@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger logger = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    @Override
    public void afterJob(JobExecution jobExecution) {

        SingletonExitCode exitCode = SingletonExitCode.getInstance();

       if(jobExecution.getStatus() == BatchStatus.COMPLETED)
       {
           logger.info("Exit with code " + ExitCode.NORMAL_END_OF_EXECUTION);
           exitCode.setExitCode(ExitCode.NORMAL_END_OF_EXECUTION);
       }
       else {
           logger.info("Exit with code " + ExitCode.ABNORMAL_END_OF_EXECUTION_WARNING);
           exitCode.setExitCode(ExitCode.ABNORMAL_END_OF_EXECUTION_WARNING);
       }
    }
}