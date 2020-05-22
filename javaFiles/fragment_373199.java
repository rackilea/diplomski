int myIntValue = 12;
String myString = "there are {online@US-server} players";
Pattern p = Pattern.compile("\\{online@(.+)\\}") ;
Matcher m = p.matcher(myString) ;

if (m.find()) { // true if the pattern is found anywhere in your string.
  System.out.println("Variable part is : " + m.group(1)); // group 1 is the capturing group
  System.out.println(myString.replaceAll("\\{online@.+\\}", String.valueOf(myIntValue)));
}