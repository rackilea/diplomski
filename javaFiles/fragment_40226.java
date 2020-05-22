String input = "8CD9261D69B796DB";

StringBuilder output = new StringBuilder();
for ( String hex : input.replaceAll( "..(?!$)", "$0," ).split( "," ) ) {
    output.append( (char)Integer.parseInt( hex, 16 ) );
}