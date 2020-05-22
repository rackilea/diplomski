public class ScheduleDeleteService extends JobService {

    @Override
    public boolean onStartJob(JobParameters params) {
        (new ScheduleDelete(){}).deleteOldEntries();
        jobFinished(params, false);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}