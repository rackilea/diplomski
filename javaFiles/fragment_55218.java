private class AsyncTaskSeekbar extends AsyncTask<String, String, String> 
{       
  @Override
  protected void doInBackground(String... params) 
  {
   try 
   {
    int time = 5000;           //5000 ms = 5 seconds  
    int incTime = 5000 / 50;   //we want it to get to 50 after 5 seconds 100ms per Seekbar unit

    for(int i = 0; i < time; i += incTime)
    {
        Thread.sleep(incTime);
        publishProgress(); // Calls onProgressUpdate()
    }
    } catch (InterruptedException e) {
    e.printStackTrace();
    } catch (Exception e) {
    e.printStackTrace();
   }
  }

  @Override
  protected void onProgressUpdate() 
  {
   seekBar.setProgess(seekBar.getProgess() + 1);
  }
}