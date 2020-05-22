public void run(int pause, int delay)
    {
        screen_list = new ScreenListener();
        init();
        try
        {   
            tm = new Timer(delay, (ActionListener)screen_list);
            tm.setInitialDelay(pause);
            tm.setRepeats(true);
            tm.start();
        }
        catch(Exception ex)
        {
             ex.printStackTrace();
        }
        finally
        {
            if(!tm.isRunning())
            {
             ...
            }
        }
     }