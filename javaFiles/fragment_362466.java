Runnable runnable = new Runnable() {
        @Override
        public void run ( ) {
            try {
                // Do the work of this task.
                ZonedDateTime zdt = ZonedDateTime.now( ZoneId.systemDefault() ); // Capture the current moment.
                System.out.println( "Current moment: " + zdt ); // Report the current moment.
                // Schedule the next run of this task.
                OffsetDateTime now = OffsetDateTime.now( ZoneOffset.UTC ) ;
                … do your database query …
                OffsetDateTime later = myResultSet.getObject( … , OffsetDateTime.class ) ;
                if( ! now.isBefore( later ) ) { … } // Verify the future moment is indeed in the future.
                Duration d = Duration.between( now , odt ) ;
                long seconds = d.toSeconds() ; // Truncates any fractional second.
                scheduledExecutorService.schedule( this , seconds , TimeUnit.SECONDS );  // Delay will not be *exactly* this amount of time due to interruptions of scheduling cores on CPU and threads by the JVM and host OS.
            } catch ( Exception e ) {
                // TODO: Handle unexpected exeption.
                System.out.println( "ERROR - unexpected exception caught on its way to reaching a scheduled executor service. Message # 55cbae82-8492-4638-9630-60c5b28ad876." );
            }
        }
    };