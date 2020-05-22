// get the scheduler factory bean from the spring context
Scheduler scheduler = (Scheduler) getApplicationContext().getBean("schedulerFactoryBean");
// get the TriggerKey 
TriggerKey triggerKey = TriggerKey.triggerKey("serviceCronTrigger");
// get the state from the triggerKey
TriggerState triggerState = scheduler.getTriggerState(triggerKey);