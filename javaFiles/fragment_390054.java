// © 2013 Basil Bourque. This source code may be used freely forever by anyone taking full responsibility for doing so.
// import org.joda.time.*;
// import org.joda.time.format.*;

String dateString = "2013-11-20 18:20:00 +01:00";
DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss Z");

// Time Zone list… http://joda-time.sourceforge.net/timezones.html  (not quite up-to-date, read page for details)
DateTime dateTimeInUtc = formatter.withZone( DateTimeZone.UTC ).parseDateTime( dateString );
DateTime dateTimeInPrague = formatter.withZone( DateTimeZone.forID( "Europe/Prague" ) ).parseDateTime(dateString);
DateTime dateTimeInVancouver = formatter.withZone( DateTimeZone.forID( "America/Vancouver" ) ).parseDateTime(dateString);