for (String groupName : scheduler.getJobGroupNames()) {

 for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {

  String jobName = jobKey.getName();
  String jobGroup = jobKey.getGroup();

  //get job's trigger
  List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
  Date nextFireTime = triggers.get(0).getNextFireTime(); 

    System.out.println("[jobName] : " + jobName + " [groupName] : "
        + jobGroup + " - " + nextFireTime);

  }

}