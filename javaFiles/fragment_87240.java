public class Main
{
    public static void main(String[] args)
    {
        testThread(new TestRunnable());
        println("");
        testThread(new TestRunnable2());
    }

    private static void testThread(Runnable runnable)
    {
        Thread testFinally = new Thread(runnable);

        println("thread-starting");

        testFinally.start();

        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            println("main-interrupted...");
        }

        testFinally.stop();

        println("thread-stopped");
    }

    private static class TestRunnable implements Runnable
    {
        @Override
        public void run()
        {
            try
            {
                println("trying");
                throw new IllegalStateException("catching");
            }
            catch (RuntimeException e)
            {
                println(e.getMessage());
            }
            finally
            {
                println("finally-sleeping");

                try
                {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e)
                {
                    println("finally-interrupted");
                }

                println("finally-done");
            }
        }
    }

    private static class TestRunnable2 implements Runnable
    {
        @Override
        public void run()
        {
            try
            {
                println("trying-sleeping");

                Thread.sleep(5000);
            }
            catch (InterruptedException e)
            {
                println("trying-interrupted");
            }
            finally
            {
                println("finally-sleeping");
                try
                {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e)
                {
                    println("finally-interrupted");
                }
                println("finally-done");
            }
        }
    }

    private static void println(String line)
    {
        System.out.printf("%s [%s]%n", line, Thread.currentThread().getName());
        System.out.flush();
    }
}