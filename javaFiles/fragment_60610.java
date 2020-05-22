(AsyncTask<String,String,Boolean>(){

   protected Boolean doInBackground(String... params) {
   try {
        Process p1 = java.lang.Runtime.getRuntime().exec("ping -c 1 www.karlol.com");
        int returnVal = p1.waitFor();
        boolean reachable = (returnVal==0);
        canshowview = true;
        progress.dismiss();
        return reachable;

    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
   return false
}


   protected void onPostExecute(Boolean result) 
{
    /// do something here
    super.onPostExecute(result);
}
}).execute()