Scheduler s;
ScheduleOptions so = Scheduler.NOW(times, period); // times == -1 for endless
so.canRunConcurrently(canRunConcurrently);
so.config(config);
so.name(name);
s.schedule(job, so);