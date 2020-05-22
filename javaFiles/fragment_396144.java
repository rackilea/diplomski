Pattern pattern = Pattern.compile( "This is a (apple|orange|peach)" );

    Matcher matcher = pattern.matcher( "This is a orange" );
    if( matcher.find() ) {
        System.out.println( matcher.group( 1 ) );
    }