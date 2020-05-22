String input = "we:PR show:V";
Pattern pattern = Pattern.compile("[^:]+:(\\S+)(?:\\s+|$)");
Matcher matcher = pattern.matcher(input);
int start = 0;
while (matcher.find(start)) {
    String match = matcher.group(1); // = "PR" then "V"
    // Do stuff with match
    start = matcher.end( );
}