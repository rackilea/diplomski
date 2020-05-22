public boolean areTilesValidByDate( final List< Tile > tiles ) {
    Objects.requireNonNull​( tiles ) ;  // Verify we were passed a list.

    int limit = 5 ;
    if( tiles.size() != limit ) {      // If unexpected size, the list cannot be valid.
        return false ;
    }

    ZoneId z = ZoneId.of( "Africa/Tunis" ) ;
    LocalDate tomorrow = LocalDate.now( z ).plusDays( 1 ) ;  // Tomorrow is today plus one day.
    LocalDate localDate = tomorrow ;

    // Loop through the five dates we expect to find in the existing tiles.
    for ( int i = 1 ; i <= limit ; i ++ ) {
        if( localDate.getDayOfWeek().equals( DayOfWeek.SUNDAY ) { // If this date is a Sunday…
            localDate = localDate.plusDays( 1 ) ; // Omit Sunday, bump to the next date.
        }
        Tile tile = tiles.get( i - 1 ) ;  // Subtract one for annoying zero-based index counting rather than 1-based ordinal counting. Index-counting comes from simplistic array and byte-jumping code in old C-style languages, and is a habit the industry finds difficult to shake off.
        if( ! tile.localDate.isEqual( localDate ) {
            return false ;
        }
        // Set up the next loop.
        localDate = localDate.plusDays( 1 ) ;
    }
    // If we make it to this point, the list must be valid.
    return true ;
}