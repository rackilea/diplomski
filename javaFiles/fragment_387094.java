for ( Map.Entry<DayOfWeek , LocalTime> entry : dayToTimeMap.entrySet () ) {
    DayOfWeek key = entry.getKey ();
    LocalTime value = entry.getValue ();
    int comparison = key.compareTo ( today );
    if ( comparison < 0 ) { // if earlier day…
        earlier.add ( key );
    } else if ( comparison == 0 ) { //If same day…
        if ( value.isBefore ( now ) ) {
            earlier.add ( key );
        } else {  // Else same time as now or later than now…
            later.add ( key );
        }
    } else if ( comparison > 0 ) {
        later.add ( key );
    } else {
        throw new RuntimeException ( "Unexpectedly reached IF-ELSE for comparison: " + comparison );
    }
}