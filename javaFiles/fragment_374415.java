LocalDateTime ldt = 
    LocalDateTime.of(
        LocalDate.of( 2018 , Month.January , 23 ) ,
        LocalTime.of( 9 , 0 ) 
    )
;

ZoneId zLosAngeles = ZoneId.of( "America/Los_Angeles" ) ;  // Seattle time zone.
ZonedDateTime zdtSeattle = ldt.atZone( zLosAngeles ) ;

ZoneId zChicago = ZoneId.of( "America/Chicago" ) ;  
ZonedDateTime zdtChicago = ldt.atZone( zChicago ) ;

ZoneId zLondon = ZoneId.of( "Europe/London" ) ;  
ZonedDateTime zdtLondon = ldt.atZone( zLondon ) ;