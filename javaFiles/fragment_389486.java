final OneoffTask task = new OneoffTask.Builder()

        // The Service which executes the task.
        .setService(MyTaskService.class) 

        // A tag which identifies the task
        .setTag(TASK_TAG) 

        // Sets a time frame for the execution of this task in seconds.
        // This specifically means that the task can either be
        // executed right now, or must have executed at the lastest in one hour.
        .setExecutionWindow(0L, 3600L)  

        // Task is persisted on the disk, even across boots                          
        .setPersisted(true) 

        // Unmetered connection required for task
        .setRequiredNetwork(Task.NETWORK_STATE_UNMETERED) 

        // Attach data to the task in the form of a Bundle
        .setExtras(dataBundle)

        // If you set this to true and this task already exists
        // (just depends on the tag set above) then the old task
        // will be overwritten with this one.
        .setUpdateCurrent(true)

        // Sets if this task should only be executed when the device is charging
        .setRequiresCharging(false)

        .build();
mGcmNetworkManager.schedule(task);