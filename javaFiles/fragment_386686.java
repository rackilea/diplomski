AsyncTask<Void, double[], Void> task = new AsyncTask<Void, double[], Void>(activity);
{
     private WeakReference<Activity> activityReference;

     public AsyncTask(Activity activity)
     {
          this.activityReference = new WeakReference<Activity>(activity);
     }

     protected void onProgressUpdate(int... progress) 
     {
         Activity activity = activityReference.get();
         if(activity != null)
         {
             activity.updateProgres(...);
         }
     }    
}