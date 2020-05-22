public class TimerTaskA extends TimerTask
{

    public void doCoolThings()
    {
        processEvent1();
        processEvent2();
        processEvent3();
    }

    @Override
    public void run()
    {
        doCoolThings();
    }
}