String content = "/qw/ty/xx/dc3/124";
String replacement = "replacement";

Pattern regex = Pattern.compile("((?:/[^/]+){2}/)([^/]*)(\\S*)", Pattern.MULTILINE);

Matcher matcher = regex.matcher(content);
if(matcher.find()){
    String result = matcher.replaceFirst("$1" + replacement + "$3");
    System.out.println(result);
}