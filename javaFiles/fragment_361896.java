// © 2013 Basil Bourque. This source code may be used freely forever by anyone taking full responsibility for doing so.
// import org.joda.time.*;
// import org.joda.time.format.*;

DateTime nowInParis = new DateTime( DateTimeZone.forID( "Europe/Paris" ) );
DateTime newDayInParis = nowInParis.plusDays( 1 ).withTimeAtStartOfDay();