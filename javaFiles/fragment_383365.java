Map<String, Serializable> jobData = Maps.newHashMap();
        jobData.put("yourkey", "youdata");
        ...
JobDetail job = newJob(TestJob.class).usingJobData(jobData)
      .build();
        //build your trigger
scheduler.scheduleJob(job, trigger)