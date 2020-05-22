Instant instant = Instant.now();
for ( int i = 0; i < 10; i++ )
{
    System.out.println( instant.toString() );
    // Choose whatever interval size you need in your specific case.
    instant = instant.plus( 1, ChronoUnit.MILLIS );
}