@Override
    public String process(Long jobId) throws Exception {
        BatchStatus jobStatus = explorer.getJobExecution(jobId).getStatus();
        LOGGER.info("The Job ID is: " + jobId);
        LOGGER.info("The job status is: "+jobStatus);
        return null;
    }