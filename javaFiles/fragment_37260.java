class MyDecider implements JobExecutionDecider {

    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        JobParameters jobParameters = jobExecution.getJobParameters();
        // get the job parameter from jobParameters
        return null; // return the FlowExecutionStatus as needed
    }
}