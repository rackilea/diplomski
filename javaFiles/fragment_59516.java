ZoneId z = ZoneId.of( "Africa/Tunis" ) ;
LocalDate tomorrow = LocalDate.now( z ).plusDays( 1 ) ;  // Tomorrow is today plus one day.
LocalDate localDate = tomorrow ;

for ( int i = 1 ; i <= limit ; i ++ ) {
    if( localDate.getDayOfWeek().equals( DayOfWeek.SUNDAY ) { // If this date is a Sunday…
        localDate = localDate.plusDays( 1 ) ; // Omit Sunday, bump to the next date.
    }
    Tile tile = new Tile( localDate ) ;
    tiles.add( tile ) ;
    // Set up the next loop.
    localDate = localDate.plusDays( 1 ) ;
}