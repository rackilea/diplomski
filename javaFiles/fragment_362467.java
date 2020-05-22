package work.basil.example;

import java.util.concurrent.*;
import java.time.*;

public class ScheduleNextTaskExample {
    public static void main ( String[] args ) {
        ScheduleNextTaskExample app = new ScheduleNextTaskExample();
        app.doIt();
    }

    private void doIt ( ) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        Runnable runnable = new Runnable() {
            @Override
            public void run ( ) {
                try {
                    ZonedDateTime zdt = ZonedDateTime.now( ZoneId.systemDefault() ); // Capture the current moment.
                    System.out.println( "Current moment: " + zdt ); // Report the current moment.
                    scheduledExecutorService.schedule( this , 10L , TimeUnit.SECONDS );  // Delay will not be *exactly* this amount of time due to interruptions of scheduling cores on CPU and threads by the JVM and host OS.
                } catch ( Exception e ) {
                    // TODO: Handle unexpected exeption.
                    System.out.println( "ERROR - unexpected exception caught on its way to reaching a scheduled executor service. Message # 55cbae82-8492-4638-9630-60c5b28ad876." );
                }
            }
        };

        // Jump-start this perpetual motion machine.
        scheduledExecutorService.schedule( runnable , 0L , TimeUnit.SECONDS );  // Start immediately, no delay.
        try {
            Thread.sleep( TimeUnit.MINUTES.toMillis( 2 ) );  // Let our app, and the executor, run for 2 minutes, then shut them both down.
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        scheduledExecutorService.shutdown();
        System.out.println( "INFO - Executor shutting down. App exiting. " + ZonedDateTime.now( ZoneId.systemDefault() ) );

    }
}