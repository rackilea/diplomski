String regex = "[^\\s\\\\]+(?:\\\\.[^\\s\\\\]*)*";
String string = "tag0 tag1 yellow\\ green tag2";

Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
    }
}