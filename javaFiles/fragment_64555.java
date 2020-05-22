String value = "(IABIG-02\tComputer Graphics\t5) or ((AIBJH88\tComputer Vision\t5) and (AIKKH10\tComputer Architecture\t5))";
Pattern pattern = Pattern.compile("\\((\\w|-)+\\t\\w+( \\w+)*\\t\\d\\)");
Matcher matcher = pattern.matcher(value);
StringBuilder builder = new StringBuilder(value.length());
Map<String, Character> replacements = new HashMap<>();
char c = 'A';
int index = 0;
while (matcher.find(index)) {
    builder.append(value, index, matcher.start());
    String found = matcher.group();
    Character replacement = replacements.get(found);
    if (replacement == null) {
        replacement = c++;
        replacements.put(found, replacement);
    }
    builder.append(replacement);
    index = matcher.end();
}
if (index < value.length()) {
    builder.append(value, index, value.length());
}

System.out.println(builder);