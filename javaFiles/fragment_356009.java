Pattern stuff = Pattern.compile("[\\w']+|[\\s.,!?;:-]");
Matcher matcher = stuff.matcher("Hello, this isn't working!");
List<String> matchList = new ArrayList<String>();
while (matcher.find()) {
    matchList.add(matcher.group(0)); // add match to the list
}