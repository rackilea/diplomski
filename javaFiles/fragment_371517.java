public class FindIt implements Runnable
{
    private int numToFind;
    private int numToStart;
    private int numToEnd;

    public FindIt( int nF, int nS, int nE )
    {
        numToFind = nF;
        numToStart = nS;
        numToEnd = nE;
    }

    public void run()
    {
        int counter = 0;

        int numAt = numToStart;

        for ( int i = 0; i < ( numToEnd - numToStart ) + 1; i++ )
        {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() 
                + " detected interruption, exiting");
                return;
            }
            counter++;

            if ( counter == 10 )
            {
                counter = 0;
                Thread.yield();
            }

            if ( numAt++ == numToFind )
            {
                System.out.println( "The target number, " + numToFind + ", has been found by " + Thread.currentThread().getName() + "." );
            }

            else
            {
                System.out.println( Thread.currentThread().getName() + " has analyzed the number " + ( numAt - 1 ) + " - not the target number." );
            }

        }   
    }
}