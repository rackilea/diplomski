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