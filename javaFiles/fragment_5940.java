private final Object lock = new Object();

public synchronized void startAuth(Intent i)
{
    m_intent = i;
    Thread thread = new Thread()
    {
        @Override 
        public void run()
        {
            MainActivity.this.runOnUiThread(new Runnable() 
            {
                public void run() 
                {
                    startActivityForResult(m_intent, 1);
                }
            });     
        }           
    };

    thread.start();
}

// authenticate function
public String[] authenticate()
{
    String[] ret = new String[2];
    Intent i = new Intent(getApplicationContext(), LoginActivity.class);

    startAuth(i);

    // waiting for login
    synchronized (lock) 
    {
        try 
        {
            lock.wait();
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }

// writing results
    ret[0] = m_sUser;
    ret[1] = m_sPass;

    return ret;
}