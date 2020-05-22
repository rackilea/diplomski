final List<Long> executionIds = jobService.findJobExecutionIdsByUser("user");
final List<JobExecution> executions = new ArrayList<>();

for (Long executionId : executionIds) {
    final JobExecution execution = explorer.getJobExecution(executionId);

    if (execution != null) {
        executions.add(execution);
    }
}