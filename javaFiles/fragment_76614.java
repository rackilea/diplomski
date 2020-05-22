Handler handler = new Handler();
Runnable r = new Runnable()
{
    public void run()
    {
        //what ever you do here will be done after 500 mili seconds delay.
        runAlgorithm();
    }
};
handler.postDelayed(r, 500);