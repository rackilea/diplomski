public class Main
{
    public static void main(final String[] args) throws InterruptedException
    {
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                System.out.println("Shutdown hook called!");
            }
        });

        while (true)
        {
            Thread.sleep(1000);
        }
    }
}