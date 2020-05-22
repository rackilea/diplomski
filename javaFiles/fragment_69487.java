public class MovieUpdatesService extends JobService {

private static final String TAG = "MovieUpdatesService";
private boolean jobCancelled = false;
private String siteDetails = "";  <----

//Use this method from the Activity
public void setSiteDetails(String _siteDetails) {
  siteDetails = _siteDetails
}

@Override
public boolean onStartJob(JobParameters params) {
    Log.d(TAG, "Job started");
    doBackgroundWork(params);
    return true;
}

public void doBackgroundWork(final JobParameters params) {
    if (jobCancelled)
        return;

    //use siteDetails here

    Log.d(TAG, "Job finished");
    jobFinished(params, false);
}

@Override
public boolean onStopJob(JobParameters params) {
    Log.d(TAG, "Job cancelled before completion");
    jobCancelled = true;
    return true;
  }
}