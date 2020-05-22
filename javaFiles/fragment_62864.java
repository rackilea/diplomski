...
    RunningJob runjob = jobclient.submitJob(conf); 
    while (!runjob.isComplete()) {
        System.out.println("sleeping for 5 sec...");
        Thread.sleep(5000);
    }
    TaskReport[] maps = jobclient.getMapTaskReports(runjob.getID());
    ...