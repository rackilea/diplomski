String path1 = "TEST(\":\")/Role[@name=\"TestRole\"]";
String pattern = "TEST\\(\":\"\\)/(\\w+)\\[@name=\"(.*)\"]";
Pattern pat = Pattern.compile(pattern);
Matcher match = pat.matcher(path1);
if ( match.find() ) {
    System.out.println(match.group());
}