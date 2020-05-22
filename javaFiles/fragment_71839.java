public class Test
{
    public static void main(String... args)
    {
        Thread thread = new Thread()
        {

            public void run()
            {
                while (true){
                    System.out.println("Hello World");
                    try
                    {
                        Thread.sleep(1000); // 1 second
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }
}