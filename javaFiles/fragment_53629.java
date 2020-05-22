// © 2013 Basil Bourque. This source code may be used freely forever by anyone taking full responsibility for doing so.
// import org.joda.time.*;
// import org.joda.time.format.*;

DateTimeZone timeZone = DateTimeZone.forID( "Europe/London" );
DateTime dateTimeNew = new DateTime( timeZone );
DateTime dateTimeOld = dateTimeNew.minusHours( 2 );

Period period = new Period( dateTimeOld, dateTimeNew );