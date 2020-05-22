/* Counts the number of contiguous stretches of non-valid pairs between
 * contiguous stretches of valid pairs
 */
private static final String[] valids = 
    {"AT", "TA", "AA", "TT", "CG", "GC", "CC", "GG"};

public static int mismatches( String str ){
    String strToSearch = "(?:(?:..)*?)((?:" + String.join( "|", valids) + ")+)";
    Pattern strPattern = Pattern.compile( strToSearch);
    Matcher matcher = strPattern.matcher(str);
    int counter = 0;
    int start = 0;
    int end = 0;
    while(matcher.find( start )){
        int s = matcher.start(1);
        end = matcher.end(1);
        if( s > start ){
            ++counter;
            // System.out.println( "s>Start "  + s );
        }
        // System.out.println( "match:" + matcher.group() +  " s=" + s );
        start = matcher.end();
    }
    if( end < str.length() ){
        ++counter;
        // System.out.println( "end< length" );
    }
    return counter;
}