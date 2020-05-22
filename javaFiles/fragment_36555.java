Job job = loadJobFromDB();
runJob(job);

public void runJob(Job Job){
    if(job.getPreviousJob() != null){
        runJob(job.getPreviousJob());
    }

    job.start();
}