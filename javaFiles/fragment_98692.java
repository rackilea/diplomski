// Simulate arguments passed.
LocalTime lt = LocalTime.of( 14 , 0 );
ZoneId z = ZoneId.of( "Africa/Tunis" ); // Or "America/Chicago", etc.
YearMonth ym = YearMonth.now( z );
DayOfWeek dow = DayOfWeek.WEDNESDAY;
Mode mode = Mode.PRIOR ;  // Mode.PRIOR, Mode.LATER, Mode.VALUE.
int occurrences = 3; // TODO: Add code to verify this value is in range of 1-5, not zero, not >5.

// Logic
int initialCapacity = 5; // Max five weeks in any month.
List< ZonedDateTime > moments = new ArrayList<>( initialCapacity );
switch ( mode ) {
    case PRIOR:
        // Start with first day-of-week in month.
        LocalDate firstDowOfMonth = ym.atDay( 1 ).with( TemporalAdjusters.firstInMonth( dow ) );
        // Work our way down through the month, adding a week at a time.
        for ( int i = 0 ; i < occurrences ; i++ ) {
            LocalDate ld = firstDowOfMonth.plusWeeks( i );
            ZonedDateTime zdt = ZonedDateTime.of( ld , lt , z );
            if ( YearMonth.from( zdt ).equals( ym ) ) {  // If in same month…
                moments.add( zdt );
            }
        }
        break;

    case LATER:
        // Start with last day-of-week in month.
        LocalDate lastDowOfMonth = ym.atDay( 1 ).with( TemporalAdjusters.lastInMonth( dow ) );
        // Work our way up through the month, subtracting a week at a time.
        for ( int i = 0 ; i < occurrences ; i++ ) {
            LocalDate ld = lastDowOfMonth.minusWeeks( i );
            ZonedDateTime zdt = ZonedDateTime.of( ld , lt , z );
            if ( YearMonth.from( zdt ).equals( ym ) ) {  // If in same month…
                moments.add( zdt );
            }
        }
        Collections.sort( moments ); // If you want the list to be in chronological order, sort.  Otherwise in reverse chronological order for this `Mode.LATER`.
        break;

    case VALUE:
        // Get the nth day-of-week in month.
        LocalDate nthDowInMonth = ym.atDay( 1 ).with( TemporalAdjusters.dayOfWeekInMonth( occurrences , dow ) );
        ZonedDateTime zdt = ZonedDateTime.of( nthDowInMonth , lt , z );
        if ( YearMonth.from( zdt ).equals( ym ) ) {  // If in same month…
            moments.add( zdt );
        }
        break;

    default:  // Defensive programming, testing for unexpected values.
        System.out.println( "ERROR - should not be able to reach this point. Unexpected `Mode` enum value." );
        break;
}
// return `moments` list from your method.
System.out.println( "moments:\n" + moments );