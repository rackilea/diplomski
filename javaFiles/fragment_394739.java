static SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
static void selectLines() throws ParseException {
    Date now = new Date();
    now = sdf.parse( "2014 Jan 1 02:00:00" ); // fake, just for testing
    Date nowMinusGap = new Date( now.getTime() - gapInMillis( gap ) );
    System.out.println( nowMinusGap + " - " + now );

    String line;
    while( (line = getLine()) != null ){
        Date timeFromLine = null;
        for( int year = now.getYear()+1900; year > 2000; year-- ){
            String lineToParse = year + " " + line;
            timeFromLine = sdf.parse( lineToParse );
            if( timeFromLine.before( now ) ) break;
        }
        System.out.println( "line: " + timeFromLine );
        if( timeFromLine.after( nowMinusGap ) &&
            timeFromLine.before( now ) ){
            System.out.println( "line: " + timeFromLine + " in range" );
        }
    }
}