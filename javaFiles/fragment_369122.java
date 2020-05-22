ZoneId zoneSofia = ZoneId.of( "Europe/Sofia" );
ZoneRules zoneRules = zoneSofia.getRules();

// Pick a moment, arbitrarily.
ZonedDateTime zdt = ZonedDateTime.of( 2019 , 10 , 15 , 10 , 0 , 0 , 0 , zoneSofia );
// Is DST in effect at that moment?
boolean isDst = zoneRules.isDaylightSavings( zdt.toInstant() );

// When are the closest offset transitions, previous (in the past), and next (in the future).
ZoneOffsetTransition previousTransition = zoneRules.previousTransition( zdt.toInstant() );
ZoneOffsetTransition nextTransition = zoneRules.nextTransition( zdt.toInstant() );

// When is the next transition happening in UTC? In Sofia time?
Instant nextTransitionInstant = nextTransition.getInstant();  // An `Instant`` is always in UTC, by definition.
ZonedDateTime nextTransactionZdt = nextTransitionInstant.atZone( zoneSofia ); // Same moment, same point on the timeline, different wall-clock time.
boolean isDstAfterTransition = zoneRules.isDaylightSavings( nextTransactionZdt.toInstant() );