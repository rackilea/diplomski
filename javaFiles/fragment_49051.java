String groupnames[] = stdScheduler.getJobGroupNames();
 for (String groupName : groupnames) {
     String[] jobNames = stdScheduler.getJobNames(groupName);
     for (String jobName : jobNames) {
            if (jobName.equals("jobName")) {
                    stdScheduler.pauseJob(jobName, groupName);
            }
     }
 }