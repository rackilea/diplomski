public class DecisionStepThreeTasklet implements Tasklet {

    @Autowired
    private SimpleJob job;

    @Autowired
    private Step startingStep;

    @Autowired
    private Step secondStep;

    public RepeatStatus execute(final StepContribution contribution, final ChunkContext chunkContext) {
        Collection<StepExecution> stepExecutions = chunkContext.getStepContext().
                getStepExecution().getJobExecution().getStepExecutions();

        int stepCount = stepExecutions.size();
        StepExecution lastStepExecution = getLastStep(stepExecutions);

        if (Constants.STEP_EXIT_STATUS_CONTINUE.equals(lastStepExecution.getExitStatus().getExitCode())) {
            job.addStep(copyStep(startingStep, "startingStep" + ++stepCount));
            job.addStep(copyStep(secondStep, "secondStep" + ++stepCount));
        }
        return RepeatStatus.FINISHED;
    }

    public StepExecution getLastStep(final Collection<StepExecution> c) {
        Iterator<StepExecution> itr = c.iterator();
        StepExecution lastElement = itr.next();
        while(itr.hasNext()) {
            lastElement=itr.next();
        }
        return lastElement;
    }

    private Step copyStep(final Step parent, final String name) {
        return new Step() {
            public String getName() {
                return name;
            }
            public boolean isAllowStartIfComplete() {
                return parent.isAllowStartIfComplete();
            }
            public int getStartLimit() {
                return parent.getStartLimit();
            }
            public void execute(final StepExecution stepExecution) throws JobInterruptedException {
                parent.execute(stepExecution);
            }
        };
    }    
}