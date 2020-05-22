public static YourClassName fromString( String str ) {
    YourClassName result = new YourClassName();

    // remove the start and ending ( not tested :P )
    String trimmed = str.substring( 6, str.length - 7 );
    String[] valuePairs = trimmed.split( ", " );
    Map<String, String> values = new HashMap<>();

    // convert value pairs into a map
    for ( String valuePair : valuePairs ) {
        String[] pair = valuePair.split( ":" );
        String key = pair[0];
        String value = pair[1];
        values.put( key, value );
    }

    // set the values one by one
    if ( values.get( "name" ) != null ) result.name = values.get( "name" );
    if ( values.get( "firstEventResult" ) != null ) result.firstEventResult = Integer.parse( values.get( "firstEventResult" ) );
    // and all others...
    return result;
}