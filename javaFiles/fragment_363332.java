// © 2013 Basil Bourque. This source code may be used freely forever by anyone taking full responsibility for doing so.

org.joda.time.DateTime now = new org.joda.time.DateTime(); // Using host system's clock and default time zone.
org.joda.time.DateTime utc = now.toDateTime( org.joda.time.DateTimeZone.UTC );
System.out.println( "Server's default local time in ISO 8601 format: " + now );
System.out.println( "UTC (Zulu) time zone: " + utc );