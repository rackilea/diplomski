// Define a new Trigger
Trigger trigger = newTrigger()
.withIdentity("newTrigger", "group1")
.startNow()
.build();

// tell the scheduler to remove the old trigger with the given key, and put the new one in its place
sched.rescheduleJob(triggerKey("oldTrigger", "group1"), trigger);