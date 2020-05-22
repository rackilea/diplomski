target.addJob(configurationMock);
Scheduler sched = (Scheduler) Whitebox.getInternalState(target, "scheduler");

//wait up to 1 second
for (int i = 0; i < 100; i++) {
    if (!sched.checkExists(new JobKey(configurationMock.getId()))) Thread.sleep(10);
    else break;
}

assertTrue(sched.checkExists(new JobKey(configurationMock.getId())));