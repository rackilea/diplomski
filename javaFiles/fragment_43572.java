private JobInfo buildJobInfoForTask(Context context,
                                    long timeTillFutureEvent) {
    ComponentName serviceComponent = new ComponentName(context, SchedulerService.class);

    return new JobInfo.Builder(FUTURE_JOB_ID, serviceComponent)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_NONE)
            .setOverrideDeadline(timeTillFutureEvent)
            .setRequiresDeviceIdle(false)
            .setRequiresCharging(false)
            .setPersisted(true)
            .build();
}