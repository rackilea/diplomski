Set<String> ignoredStrings = new HashSet<String>(Arrays.asList(arr));

String line;
while ((line = file.readLine()) != null) {
    if (!ignoredStrings.contains(line)) {
        buffer.append(line);
        buffer.append("\n");
    }
}