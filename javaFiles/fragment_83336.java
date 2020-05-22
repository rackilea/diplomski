Pattern pattern = Pattern.compile( "^(.+)?(?= [0-9])" ); // regular expression for street
Matcher matcher = pattern.matcher( originalString );

if ( matcher.find() )
    String street = matcher.group();

String number = // regex would be: [0-9]+
String addition = // zero or more characters after a number