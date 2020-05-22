// adaptation of splitLine(), just iterate through all lines, then you will have
// everything in the map and you can iterate over the entry sets.
private void addLine(String line, Map<String, String> stops) {
    Matcher matcher = pattern.matcher(line);
    if (matcher.find()) {
        if (stops.containsKey(matcher.group(1))) {
            stops.put(matcher.group(1), stops.get(matcher.group(1)) + matcher.group(2));
        } else {
            stops.put(matcher.group(1), matcher.group(2).trim());
        }
    }
}