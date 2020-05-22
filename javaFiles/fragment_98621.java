List<String> toRemove = Arrays.asList("12", "23", "34");
String text = "Hello 12 23 34 55";
String delimiter = " ";

text = Pattern.compile(delimiter).splitAsStream(text)
    .filter(s -> !toRemove.contains(s))
    .collect(Collectors.joining(delimiter));
System.out.println("\"" + text + "\"");