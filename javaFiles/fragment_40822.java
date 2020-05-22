String input = "Some words <firstMatch> some words <secondMatch> some more words <ThirdMatch>";
Pattern pattern = Pattern.compile( "<[^>]*>" );
Matcher m = pattern.matcher( input );
while ( m.find() ) {
   System.out.println( m.group(0) ); // = m.group(), the whole match value
}