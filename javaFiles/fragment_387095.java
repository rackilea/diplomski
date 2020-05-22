System.out.println ( "dayToStringMap: " + dayToTimeMap );
System.out.println ( "sorted by today: " + today + " " + now + " is: " );
for ( DayOfWeek dayOfWeek : later ) {
    LocalTime localTime = dayToTimeMap.get ( dayOfWeek );
    System.out.println ( dayOfWeek + " " + localTime );
}
for ( DayOfWeek dayOfWeek : earlier ) {
    LocalTime localTime = dayToTimeMap.get ( dayOfWeek );
    System.out.println ( dayOfWeek + " " + localTime );
}