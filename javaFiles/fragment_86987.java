Pattern pattern = Pattern.compile("(?:[^,/]+|/.)+");
String test = "a,b/,b//,c///,//,d///,";
Matcher matcher = pattern.matcher(test);
while (matcher.find()) {
    System.out.println(matcher.group().replaceAll("/(.)", "$1"));
}