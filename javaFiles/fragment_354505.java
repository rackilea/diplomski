Pattern pattern = Pattern.compile("name:\\s+(.*?),.*?Batch ID:\\s+(\\d+)");
Matcher matcher;
for (String string : strings) {
    matcher = pattern.matcher(string);
    while (matcher.find()) {
        System.out.println(
                String.format("name : %s, age : %s", matcher.group(1), matcher.group(2))
        );
    }
}