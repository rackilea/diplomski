int year = 2003;
int week = 1; // Domain: 1 to 53.

// Build a String in ISO 8601 Week format: YYYY-Www-D
// Hard-coding a `1` for Monday, the standard first-day-of-week.
String input = ( String.format( "%04d", year ) + "-W" + String.format( "%02d", week ) + "-1" );

// Specify the time zone by which to define the beginning of a day.
DateTimeZone timeZone = DateTimeZone.UTC; // Or: DateTimeZone.forID( "America/Montreal" );

// Calculate beginning and ending, using Half-Open (inclusive, exclusive) approach.
DateTime dateTimeStart = new DateTime( input, timeZone );
DateTime dateTimeStop = dateTimeStart.plusWeeks( 1 );

// Use Joda-Time's tidy Interval class to represent the entire week. Use getters to access start and stop.
Interval weekInterval = new Interval( dateTimeStart, dateTimeStop );

// Is today in that week? Joda-Time has handy methods: contains, isBefore, isAfter, overlap.
boolean isTodayInThatWeek = weekInterval.contains( DateTime.now() );