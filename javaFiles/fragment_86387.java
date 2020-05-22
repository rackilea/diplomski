public class CustomStepExecutionListener implements StepExecutionListener {

    private static final String VALIDATION_FAILURE = "File validation failed";

    public ExitStatus afterStep(final StepExecution stepExecution) {
        ExitStatus exitStatus = stepExecution.getExitStatus();
        String exitCode = exitStatus.getExitCode();
        if (ExitStatus.FAILED.getExitCode().equals(exitCode)) {
            String exitDescription = exitStatus.getExitDescription();
            if (exitDescription.contains(VALIDATION_FAILURE)) {
                return new ExitStatus(exitCode, VALIDATION_FAILURE);
            }
        }
        return null;
    }

    public void beforeStep(final StepExecution stepExecution) {
        //no-op
    }

}