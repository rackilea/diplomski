// retrieve the trigger
Trigger oldTrigger = sched.getTrigger(triggerKey("oldTrigger", "group1");

// obtain a builder that would produce the trigger
TriggerBuilder tb = oldTrigger.getTriggerBuilder();

// update the schedule associated with the builder, and build the new trigger
// (other builder methods could be called, to change the trigger in any desired way)
Trigger newTrigger = tb.withSchedule(simpleSchedule()
.withIntervalInSeconds(10)
.withRepeatCount(10)
.build();
//Reschedule
sched.rescheduleJob(oldTrigger.getKey(), newTrigger);