List < DateTimeFormatter > dateFormatters = new ArrayList <>( 2 );
dateFormatters.add( DateTimeFormatter.ofPattern( "uuuu-MM-dd" ) );  // BEWARE of ambiguity in these formatters regarding month-versus-day.
dateFormatters.add( DateTimeFormatter.ofPattern( "dd-MM-uuuu" ) );

String input = "1990-02-07";
// String input = "12-02-1990" ;

if ( null == input )
{
    throw new IllegalArgumentException( "Passed null argument where a date-time string is expected. Message # c7a4fe0e-9500-45d5-a041-74d457381008." );
} else if ( input.length() <= 10 )
{
    LocalDate ld = null;
    for ( DateTimeFormatter f : dateFormatters )
    {
        try
        {
            ld = LocalDate.parse( input , f );
            System.out.println( ld );
        } catch ( Exception e )
        {
            // No code here.
            // We purposely ignore this exception, moving on to try the next formatter in our list.
        }
    }
} else if ( ( input.length() > 10 ) && input.substring( input.length() - 1 ).equalsIgnoreCase( "Z" ) ) // If over 10 in length AND ends in a Z.
{
    Instant ld = null;
    try
    {
        ld = Instant.parse( input );  // Uses `DateTimeFormatter.ISO_INSTANT` formatter.
    } catch ( Exception e )
    {
        throw new IllegalArgumentException( "Unable to parse date-time string argument. Message # 0d10425f-42f3-4e58-9baa-84ff949e9574." );
    }
} else if ( input.length() > 10 )
{
    // TODO: Define another list of formatters to try here.
} else if ( input.length() == 0 )
{
    throw new IllegalArgumentException( "Passed empty string where a date-time string is expected. Message # 0ffbd9b6-8905-4e28-a732-0f402d4673df." );
} else  // Impossible-to-reach, for defensive programming.
{
    throw new RuntimeException( "ERROR - Unexpectedly reached IF-ELSE when checking input argument. Message # 6228d9e0-047a-4b83-8916-bc526e0fd22d." );
}
System.out.println("Done running.");