String line = "1,Kit,23\n2,Ret,211";

final Map<String, List<InputRow>> regexResults = new HashMap<>();
Pattern pattern = Pattern.compile("(.+),(.+),(.+)");
final Matcher matcher = pattern.matcher(line);

List<InputRow> entry = new ArrayList<>();

while (matcher.find()) {
    entry.add(new InputRow(matcher.group(1), matcher.group(2), matcher.group(3)));
}

regexResults.put("InputRow", entry);