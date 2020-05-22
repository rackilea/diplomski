List<String> toRemove = Arrays.asList("1", "2", "3");
String text = "Hello 1 2 3";

text = Pattern.compile("").splitAsStream(text)
    .filter(s -> !toRemove.contains(s))
    .collect(Collectors.joining());
System.out.println("\"" + text + "\"");