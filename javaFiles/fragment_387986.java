ScheduledFuture<?> newJob = null;
    for(JobInterface job : allJobs)
        if (job.getJobName().equals(jobName.getJobName()))
            newJob = scheduleJob(/*arguments*/);

    if (newJob == null)
        logger.warn(/*swear loudly :)*/);