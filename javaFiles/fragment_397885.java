String input = "@rivest talk in 30 minutes #hype";
String regex = "(?<=^|(?<=[^a-zA-Z0-9-_\\\\.]))@([A-Za-z][A-Za-z0-9_]+)";
Matcher matcher = Pattern.compile(regex).matcher(input);
if (matcher.find()) {
    System.out.println(matcher.group(0));
}