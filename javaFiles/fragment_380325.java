// Extract old value without zone/offset info.
LocalDateTime ldt = myResultSet.getObject( oldColumn , LocalDateTime.class ) ;

// Guessing this time zone was originally intended. 
ZoneId z = ZoneId.of( "America/New_York" ) ;

// Arbitrarily apply the time zone that we assume, but do not truly know, was intended when that date-time was originally stored.
ZonedDateTime zdt = ldt.atZone( z ) ;
OffsetDateTime odt = zdt.toOffsetDateTime() ;

// Store the new value in a new column.
myPreparedStatement.setObject( newColumn , odt ) ;