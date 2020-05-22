for ( int i = 0 ; i < occurrences ; i++ ) {
        LocalDate ld = firstDowOfMonth.plusWeeks( i );
        ZonedDateTime zdt = ZonedDateTime.of( ld , lt , z );
        if ( YearMonth.from( zdt ).equals( ym ) ) {  // If in same month…
            moments.add( zdt );
        }
    }