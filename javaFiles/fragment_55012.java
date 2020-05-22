String input = "[title],[description blablablablablabla]";

Pattern pattern = Pattern.compile("\\[(.*?)\\]");
Matcher matcher = pattern.matcher(input);
ArrayList<String> stringList = new ArrayList<String>();

while(matcher.find()) {
    stringList.add(matcher.group(1));
}

//If you just need the results to be stored in an array of Strings anyway.
String[] stringArray = stringList.toArray(new String[stringList.size()]);