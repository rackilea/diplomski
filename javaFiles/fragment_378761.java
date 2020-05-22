Data d = new Data.Builder()
             .putInt(IntentConstants.SCHEDULE_ID, scheduleData.getScheduleID())
             .build();

long currentTime= System.currentTimeMillis();
long specificTimeToTrigger = c.getTimeInMillis();
long delayToPass = specificTimeToTrigger - currentTime;

OneTimeWorkRequest compressionWork =
                        new OneTimeWorkRequest.Builder(ScheduleWorker.class)
                                .setInputData(d)
                                .setInitialDelay(delayToPass, TimeUnit.MILLISECONDS)
                                .build();

WorkManager.getInstance().enqueue(compressionWork);