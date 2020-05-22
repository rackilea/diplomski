LocalDate start = LocalDate.parse ( "2013-04-17" );
LocalDate stop = LocalDate.parse ( "2013-05-21" );
if ( stop.isBefore ( start ) ) {
    System.out.println ( "ERROR - stop before start" );
    // FIXME: Handle error.
}