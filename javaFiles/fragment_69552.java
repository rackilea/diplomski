trigger = newTrigger()
    .withIdentity("yourJobName", "yourJobGroup")
    .withSchedule(simpleSchedule()
        .withIntervalInHours(5) // every 5 hours
        .repeatForever()) // keep going in intervals of 5h
    .startAt(dateOf(12, 0, 0)) // start at 12:00 PM
    .build();