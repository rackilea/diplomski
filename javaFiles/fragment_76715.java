public static int valid( String str ){
    Set<String> valset = new HashSet<>();
    for( String s: valids ) valset.add( s );
    int validCount = 0;
    for( int i = 0; i < str.length(); i += 2 ){
        if( valset.contains( str.substring( i, i+2 ) ) ) validCount++;
    }
    return validCount;
}