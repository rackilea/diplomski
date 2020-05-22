Pattern memberSincePattern = Pattern.compile("\\W*(\\d+):(\\d+):(\\d+)\\W*(\\d+)/(\\d+)/(\\d+)");
Matcher memberSinceMatcher = memberSincePattern.matcher("12:12:12 12/12/2012");

if(memberSinceMatcher.matches()) {
    String msGroupOne = memberSinceMatcher.group(1);
}