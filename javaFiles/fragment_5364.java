// For the first iteration, use a no-op separator
String currentSeparator = "";
for (String s : list) {
    builder.append(currentSeparator);
    builder.append(s);
    // From the second iteration onwards, use this
    currentSeparator = separator;
}