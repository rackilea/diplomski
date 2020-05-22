Set daysOfWeek = new HashSet();
daysOfWeek.add(1);
daysOfWeek.add(2);
daysOfWeek.add(5);

newTrigger().withIdentity(cronTriggerDTO.getTiggerId(), "simpleGroup")
    .startAt(getTriggerExecutionDate(cronTriggerDTO))
    .withSchedule(dailyTimeIntervalSchedule()
       .onDaysOfTheWeek(daysOfWeek)
          .startingDailyAt(new TimeOfDay(8,0)))
    .build();