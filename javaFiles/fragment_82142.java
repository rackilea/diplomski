Year year = Year.of( 2021 );  // Input the year for which we want to create a calendar by way of a SQL script.
// Verify the requested year is in the future.
if ( ! Year.now().isBefore( year ) ) { throw new IllegalArgumentException( "Year must be in the future. Message # a0720f38-f4c5-4aca-9214-d9756a91e372." ); }
String filePath = "/Users/basilbourque/calendar_" + year + ".sql";

String newline = "\n";
StringBuilder sql = new StringBuilder();
sql.append( "INSERT INTO calendar_ ( date_ , holiday_us_ ) " ).append( newline );
LocalDate firstOfYear = year.atDay( 1 );
Stream < LocalDate > dates = firstOfYear.datesUntil( firstOfYear.plusYears( 1 ) );  // Generate a stream of `LocalDate` objects, for each date from start to end, using Half-Open approach where the ending is exclusive.
String joined = 
        dates
        .map( localDate -> "( '" + localDate.toString() + "' , FALSE )" )
        .collect( 
            Collectors.joining( ", " + newline , "VALUES " + newline , newline + " ; " )   // Pass delimiter, prefix, suffix.
        )
;
sql.append( joined );

System.out.println( "sql = " + newline + sql );

try
{
    Files.writeString( 
        Paths.get( filePath ) ,
        sql , 
        StandardCharsets.UTF_8 , 
        StandardOpenOption.CREATE_NEW 
    );
}
catch ( IOException e )
{
    e.printStackTrace();
}