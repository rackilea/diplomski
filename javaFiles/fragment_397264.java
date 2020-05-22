CronTrigger cronTrigger = newTrigger()
  .withIdentity("trigger1", "testJob")
  .startAt(startDate)
  .withSchedule(CronScheduleBuilder.cronSchedule( * * * */2 * ?")
      .withMisfireHandlingInstructionDoNothing())
  .build();