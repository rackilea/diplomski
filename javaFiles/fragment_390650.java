import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecServicePerformance {

    private static int count = 100000;

    public static void main( String[] args ) throws InterruptedException {

        final int cpus = Runtime.getRuntime().availableProcessors();

        final ExecutorService es = Executors.newFixedThreadPool( cpus );

        final Vector< Batch > batches = new Vector< Batch >( cpus );

        final int batchComputations = count / cpus;

        for ( int i = 0; i < cpus; i++ ) {
            batches.add( new Batch( batchComputations ) );
        }

        System.out.println( "provisioned " + cpus + " batches to be executed" );

        // warmup
        simpleCompuation();
        computationWithObjCreation();
        computationWithObjCreationAndExecutors( es, batches );

        long start = System.currentTimeMillis();
        simpleCompuation();
        long stop = System.currentTimeMillis();
        System.out.println( "simpleCompuation:" + ( stop - start ) );

        start = System.currentTimeMillis();
        computationWithObjCreation();
        stop = System.currentTimeMillis();
        System.out.println( "computationWithObjCreation:" + ( stop - start ) );

        // Executor

        start = System.currentTimeMillis();
        computationWithObjCreationAndExecutors( es, batches );    
        es.shutdown();
        es.awaitTermination( 10, TimeUnit.SECONDS );
        // Note: Executor#shutdown() and Executor#awaitTermination() requires
        // some extra time. But the result should still be clear.
        stop = System.currentTimeMillis();
        System.out.println( "computationWithObjCreationAndExecutors:"
                + ( stop - start ) );
    }

    private static void computationWithObjCreation() {

        for ( int i = 0; i < count; i++ ) {
            new Runnable() {

                @Override
                public void run() {

                    double x = Math.random() * Math.random();
                }

            }.run();
        }

    }

    private static void simpleCompuation() {

        for ( int i = 0; i < count; i++ ) {
            double x = Math.random() * Math.random();
        }

    }

    private static void computationWithObjCreationAndExecutors(
            ExecutorService es, List< Batch > batches )
            throws InterruptedException {

        for ( Batch batch : batches ) {
            es.submit( batch );
        }

    }

    private static class Batch implements Runnable {

        private final int computations;

        public Batch( final int computations ) {

            this.computations = computations;
        }

        @Override
        public void run() {

            int countdown = computations;
            while ( countdown-- > -1 ) {
                double x = Math.random() * Math.random();
            }
        }
    }
}