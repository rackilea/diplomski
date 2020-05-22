Map<String, JobsConfig> oldJobsConfigs = new HashMap<>();
    Map<String, ScheduledFuture<?>> activeJobs = new HashMap<>()

    public void listJobList() {
        List<JobsConfig> jobsList = jobsConfigRepository.findAll();
        for (JobsConfig jobName : jobsList) {
            // If this job was there before and has not changed, do nothing.
            if (oldJobsConfigs.containsKey(jobName.getJobName()) && oldJobsConfigs.get(jobName.getJobName()).getScheduledValue().equals(jobName.getScheduledValue())) 
                break;

            // Cancel previous execution, if any.
            if (activeJobs.containsKey(jobName.getJobName()) {
                ScheduledFuture<?> job = activeJobs.get(jobName.getJobName());
                job.cancel(false);
                try {
                    job.get(); // Warning! If the job is running, blocks current thread until the job finishes. If has an endless loop, it will block current thread forever.
                } catch (CancellationException e) {
                    // Do nothing, this is good, we did not spent time waiting for the job to finish.
                } catch (InterruptedException | ExecutionException e) {
                    // Log it?
                }
            }

            ScheduledFuture<?> newJob = null;
            switch (jobName.getJobName()) {
                case "DeleteExpiredTokenJob":
                    newJob = scheduleJob(poolScheduler(), deleteExpiredTokenJob, jobName.getJobName());
                    break;
                case "TestJob":
                    newJob = scheduleJob(poolScheduler(), testJob, jobName.getJobName());
                    break;
                default:
                    logger.info(String.format("JOB NOT FOUND [%s]", jobName.getJobName()));
            }

            if (newJob != null)
                activeJobs.put(jobName.getJobName(), newJob);
        }
    }