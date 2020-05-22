public void run()
{
    ... your loop stuff ...
    // this is how we're going to do the notification.
    Runner.done();
}

public class Runner
{
    private static RaceHorse winner = null;
    synchronized static void done()
    {
        // Threads calling this are going to be RaceHorse objects.
        // Now, if there isn't already a winner, this RaceHorse is the winner.
        if (winner == null) winner = (RaceHorse) Thread.currentThread();
    }

    public static void main(String[] args)
    {
         ... create the horses ...
         // start the horses running
         obj.start();
         obj2.start();

         // wait for them to finish
         obj.join();
         obj2.join();

         System.out.println(winner.name + " wins!");
    }
}