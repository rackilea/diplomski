trigger = newTrigger()
.withIdentity("trigger3", "group1")
.startAt(tomorrowAt(15, 0, 0)  // first fire time 15:00:00 tomorrow
.withSchedule(simpleSchedule()
        .withIntervalInHours(2 * 24) // interval is actually set at 48 hours' worth of milliseconds
        .repeatForever())

.build();