// © 2013 Basil Bourque. This source code may be used freely forever by anyone taking full responsibility for doing so.
// import org.joda.time.*;
// import org.joda.time.format.*;

DateTimeZone timeZone = DateTimeZone.forID( "Europe/Athens" );

DateTime now_Athens = new DateTime( timeZone );
DateTime now_Seattle = now_Athens.toDateTime( DateTimeZone.forID( "America/Los_Angeles" ));
DateTime now_UTC = now_Athens.toDateTime( DateTimeZone.UTC );