mGcmNetworkManager.schedule(new OneoffTask.Builder()
                .setService(MyTaskService.class)
                .setTag(TASK_TAG)
                .setExecutionWindow(0L, 300L)
                .setPersisted(true)
                .setExtras(bundle)
                .build());