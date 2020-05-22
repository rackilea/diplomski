public class BackgroundTask extends AsyncTask<Void,Void,Void>{

   private ListAdapter mAdapter;

   public BackgroundTask(ListAdapter adapter)
   {
      mAdapter = adapter
   }

   public Void doInBackground (Void... params)
   {
      //define m_cPowerDrainingApps somewhere
      m_cPowerDrainingApps.killBgRunningProcesses(runningAppsList);
      try
      {
           Thread.sleep(1500);
      } catch (InterruptedException e)
      {
           e.printStackTrace();
      }
   }

   public Void onPostExecute (Void... params)
   {
      //do your UI things
      mAdapter.notifyDataSetChanged();
   }
}