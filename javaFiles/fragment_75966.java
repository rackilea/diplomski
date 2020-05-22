@Override
public ExitStatus afterStep(StepExecution stepExecution) {
    if (stepExecution.getReadCount() > 0) {
        return ExitStatus.COMPLETED;
    }
    return ExitStatus.NOOP;
}