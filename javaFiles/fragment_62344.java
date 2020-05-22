SimpleDateFormat shortFormat = new SimpleDateFormat( "dd MMM yyyy" );
SimpleDateFormat longFormat = new SimpleDateFormat( "EEE dd MMM yyyy" );
String input = ""; // from somewhere
Pattern shortFormatPattern = Pattern.compile( "[0-9]{2}\\s\p{Alpha}{3}\\s[0-9]{4}" );
Date date;
if( shortFormatPattern .matcher( input ).matches() )
{
    date = shortFormat.parse( input );
}
else
{
    date = longFormat.parse( input );
}