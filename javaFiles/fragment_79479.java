StringBuilder text = new StringBuilder("\"dim\": [{\n"
        + "\t\t\"name\": \"1\",\n"
        + "\t\t\"value\": \"43.8\"\n"
        + "\t}, {\n"
        + "\t\t\"name\": \"2\",\n"
        + "\t\t\"value\": \"27.9\"\n"
        + "\t}, {\n"
        + "\t\t\"name\": \"3\",\n"
        + "\t\t\"value\": \"36.7\"\n"
        + "\t}]");
Pattern p = Pattern.compile( "(?ms)(?:\\\"dim\\\"\\:\\s*\\[)?\\{\\s*\\\"name\\\"\\:\\s*(\\\".*?\\\")\\,\\s*\\\"value\\\"\\:\\s*(\\\".*?\\\")\\s*\\}(\\,?\\s*)(?:\\])?" );
Matcher m = p.matcher( text );
while( m.reset( text ).find() ) // since we are changing in-place we have to update the matcher every time or else the indexes will be wrong, which is also why we must do our replacements from the back
{
    if( !m.group( 3 ).isEmpty() )
        text.replace( m.start( 3 ), m.end( 3 ), ",\n" ); // format the separating commas
    else
        text.delete( m.start( 3 ), m.end() ); // delete the trailing ]
    text.delete( m.end( 2 ), m.start( 3 ) ); // delete the beginning of the {
    text.replace( m.end( 1 ), m.start( 2 ), " : " ); // set the separator
    text.delete( m.start(), m.start( 1 ) ); // trim off the end of the }
}
System.out.println( text );