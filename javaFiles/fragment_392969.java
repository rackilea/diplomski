public static boolean isJobServiceOn( Context context ) {
    JobScheduler scheduler = (JobScheduler) context.getSystemService( Context.JOB_SCHEDULER_SERVICE ) ;

    boolean hasBeenScheduled = false ;

    for ( JobInfo jobInfo : scheduler.getAllPendingJobs() ) {
        if ( jobInfo.getId() == JOB_ID ) {
            hasBeenScheduled = true ;
            break ;
        }
    }

    return hasBeenScheduled ;
}