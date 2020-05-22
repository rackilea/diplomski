Pattern pattern = Pattern.compile("<([^>]*)>");
Matcher matcher = pattern.matcher(myString);
List<String> listOfElements = new ArrayList<>();

while (matcher.find()) {
    listOfElements.add(matcher.group(1));
}
System.out.println(listOfElements);