List<JobInstance> jobInstances= jobExplorer.getJobInstances(jobName);

for (JobInstance jobInstance : jobInstances) {
    List<JobExecution> jobExecutions = jobExplorer.getJobExecutions(jobInstance);
    for (JobExecution jobExecution : jobExecutions) {
        if (jobExecution.getExitStatus().equals(ExitStatus.COMPLETED)) {
        //You found a completed job, possible candidate for a restart
        //You may check if the job is restarted comparing jobParameters
        JobParameters jobParameters = jobInstance.getParameters();
        //Check your running job if it has the same jobParameters 
        }
     }
}