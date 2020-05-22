new Thread(new Runnable() 
{
    @Override
    public void run() 
    {
        //do the code here such as sending request to server
        runOnUiThread(new Runnable() 
        {
            @Override
            public void run() 
            {
                //do here the code which interact with UI
            }
        });
    }
}).start();