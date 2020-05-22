@BeforeStep
public void retrieveSharedData(StepExecution stepExecution) {
    JobExecution jobExecution = stepExecution.getJobExecution();
    ExecutionContext jobContext = jobExecution.getExecutionContext();
    this.myList = jobContext.get("theListKey");
}