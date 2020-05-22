String ex = "(5 + 4) - 5 - (6 - (3 - 4) + (5 - (3 - 6)))";
List<String> matches = new ArrayList<>();

Pattern pattern = Pattern.compile("\\(([^\\)]+)\\)");
Matcher matcher = pattern.matcher(ex);
while (matcher.find()){
    matches.add(matcher.group(1));
}