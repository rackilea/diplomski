Pattern intsOnly = Pattern.compile("\\d+");
Matcher makeMatch = intsOnly.matcher("hello14 hai22. I am here 4522");
String inputInt = null;
while(makeMatch.find()) {
    inputInt = makeMatch.group();
    System.out.println(inputInt);
}