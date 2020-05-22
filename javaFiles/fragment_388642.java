new Thread(new Runnable()
{
    @Override
    public void run()
    {
            Main main = new Main();
            main.doProcessing();
    }
}).start();