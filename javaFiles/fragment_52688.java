String regex = "(\\w+)(?:,\\s*party of (\\d+)|(?![^,]))";
List<String> strings = Arrays.asList("John, party of 4", "william, party of 6 dislikes John, jeff");

Pattern pattern = Pattern.compile(regex);
for (String s : strings) {
    System.out.println("-------- Testing '" + s + "':");
    Matcher matcher = pattern.matcher(s);
    while (matcher.find()) {
        System.out.println(matcher.group(1) + ": " + (matcher.group(2) != null ? matcher.group(2) : "N/A"));
    }
}