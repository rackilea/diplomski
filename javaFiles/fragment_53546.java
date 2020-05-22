String input = "[a05, [a24, a23], [b08, b09], c26, c30, a22, a13, m06]";

// Strip outer [...]
String content = input.substring(1, input.length() - 1);

List<String> parts = new ArrayList<>();
Matcher m = Pattern.compile("\\[.*?\\]|[^\\[, ]+").matcher(content);
while (m.find()) {
    parts.add(m.group());
}
parts.forEach(System.out::println);