public static RunningJob myCustomRunJob(JobConf job) throws Exception {
    JobClient jc = new JobClient(job);
    RunningJob rj = jc.submitJob(job);
    if (!jc.monitorAndPrintJob(job, rj)) {
      throw new IOException("Job failed with info: " + rj.getFailureInfo());
    }
    return rj;
  }