private void RepeatTask()
{
    repeatTaskThread = new Thread()
    {
        public void run()
        {
            while (true)
            {

                FetchURL fu = new FetchURL();
                fu.Run("http://192.168.0.10/joins.txt");
                String o = fu.getOutput();
                // Update TextView in runOnUiThread
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        txtJoins.setText("Last connections: \n" + o);
                    }
                });
                try
                {
                    // Sleep for 10 minutes
                    Thread.sleep(600000)
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        };
    };
    repeatTaskThread.start();
}