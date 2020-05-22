@HandleAfterCreate
public void addNewRemoteJob(Job job) {
    remoteJobDispatcher.sendRequest(job);
    remoteJobDispatcher.waitForTheResult(job);
}

class RemoteJobDispatcher {
    @Async
    public void waitForTheResult(Job job) {
        while(true) {
            status = askRemoteServerForJobStatus(job)
            if (status != IN_PROGRESS) {
                job.setStatus(status);
                jobRepository.save(job);
                return;
            }
            sleep(2000);
        }
    }
}