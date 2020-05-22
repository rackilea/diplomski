String[] replacements = {"_", "."};
String str = "abc-123-def";

for (String replacement : replacements) {
    str = str.replaceFirst("-", replacement);
}