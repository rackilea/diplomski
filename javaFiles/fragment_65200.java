final class DemoThread
{
    public void temp()
    {
        new Thread(new Anonymous()).start();
    }

    private class Anonymous implements Runnable
    {
        public void run()
        {
            System.out.println( "Isn't it great ?" ) ;
        }
    }
}