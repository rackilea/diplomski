JobDetail existingJobDetail = sched.getJobDetail(jobName, jobGroup);
    if (existingJobDetail != null) {
        List<JobExecutionContext> currentlyExecutingJobs = (List<JobExecutionContext>) sched.getCurrentlyExecutingJobs();
        for (JobExecutionContext jec : currentlyExecutingJobs) {
            if(existingJobDetail.equals(jec.getJobDetail())) {
                //String message = jobName + " is already running.";
                //log.info(message);
                //throw new JobExecutionException(message,false);
            }
        }
        //sched.deleteJob(jobName, jobGroup); if you want to delete the scheduled but not-currently-running job
    }