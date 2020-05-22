Runnable runnable =
        ( ) -> {
            try
            {
                System.out.println( "Looking up fresh stock prices at " + Instant.now().toString() );
            }
            catch ( Exception e )
            {
                // … try to recover, if you want the scheduled executor service to continue scheduling this task.
                // Or, at least, do logging/notifications to know when and why the scheduling of this task halted.
                e.printStackTrace();
            }
        };