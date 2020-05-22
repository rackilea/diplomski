YearMonth yearMonth = startYm;
do {
    int days = 0;
    if ( startYm.equals ( stopYm ) ) { // If within the same (single) month.
        days = ( int ) ChronoUnit.DAYS.between ( start , stop );
    } else if ( yearMonth.equals ( startYm ) ) { // If on the first month of multiple months, count days.
        days = ( int ) ChronoUnit.DAYS.between ( start , startYm.plusMonths ( 1 ).atDay ( 1 ) ); //  Get first of next month, to accommodate the `between` method’s use of Half-Open logic.
    } else if ( yearMonth.isAfter ( startYm ) && yearMonth.isBefore ( stopYm ) ) { // If on the in-between months, ask for the days of that month.
        days = yearMonth.lengthOfMonth ();
    } else if ( yearMonth.equals ( stopYm ) ) {  // If on the last of multiple months.
        days = ( int ) ChronoUnit.DAYS.between ( stopYm.atDay ( 1 ).minusDays ( 1 ) , stop ); // Get last day of previous month, to accommodate the `between` method’s use of Half-Open logic.
    } else {
        System.out.println ( "ERROR - Reached impossible point." );
        // FIXME: Handle error condition.
    }
    map.put ( yearMonth , days ); // Cast long to int, auto-boxed to Integer.
    // Prep for next loop.
    yearMonth = yearMonth.plusMonths ( 1 );
} while (  ! yearMonth.isAfter ( stopYm ) );