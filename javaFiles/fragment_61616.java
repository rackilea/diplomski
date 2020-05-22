String delimiter = " ";
String regex = "(?:\\\\.|[^"+ delimiter +"\\\\])+";
// System.out.println(regex); // => (?:\\.|[^ \\])+
Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
String input = "234|Tamarind|something interesting ";
List<String> matchList = new ArrayList<>(  );
Matcher regexMatcher = pattern.matcher( input );
while ( regexMatcher.find() )
{
    // System.out.println("'"+regexMatcher.group()+"'");
    matchList.add( regexMatcher.group() );
}

System.out.println( "Unescaped/escaped test result with size: " + matchList.size() );
matchList.stream().forEach( System.out::println );