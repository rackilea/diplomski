Pattern p = Pattern.compile( "\\s*([0-9A-Fa-f]{2})" );
Matcher m = p.matcher( myString );
int lastEnd = 0;
while( m.lookingAt() ) {
    System.out.println( "Hex part:" + m.group(1) );
    lastEnd = m.end();
}   
if( lastEnd < myString.length() ) {
    System.err.println( "Encountered non-hex value at index:" + lastEnd );
}