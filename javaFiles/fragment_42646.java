double[] celsius = new double[ temperature.length ]; // added!!!
if ( tempChoice.equalsIgnoreCase( "C" ) )
{
    tempLabel = "(C)";
    for ( index = 0; index < temperature.length; )
    {
        celsius[ index ] = ( temperature[ index ] - 32 ) * 5 / 9; // modified!!!
        index++;
    }
}

// Convert in values to cm; replace the current values in precipitation
double[] centimeters = new double[ precipitation.length ]; // added!!!
if ( precipChoice.equalsIgnoreCase( "c" ) )
{
    precipLabel = "(cm)";
    for ( int i = 0; i < precipitation.length; i++ )
    {
        centimeters[ i ] = precipitation[ i ] * 2.54; // modified!!!
    }
}