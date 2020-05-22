public static Trigger buildTriggerForJob(int hours, int minutes, int seconds, String name, String groupName) {
    return org.quartz.TriggerBuilder
           .newTrigger()
           .withIdentity(name, groupName)
           .withSchedule(
                SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(hours).withIntervalInMinutes(minutes)
                .withIntervalInSeconds(seconds).repeatForever()).build();
 }