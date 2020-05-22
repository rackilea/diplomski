Path path = Paths.get("route.txt");
byte[] bytes = Files.readAllBytes(path);
String content = new String(bytes, StandardCharsets.ISO_8859_1);
content = content.replace(" ", ""); // So spaces at odd places do not need to be handled.
String[] sequences = content.split("[^\\d,]+"); // Delimit by not: digit or comma.
for (String sequence : sequences) {
    if (!sequence.isEmpty()) {
        String[] words = sequence.split(",");
        int[] numbers = Stream.of(words).mapToInt(Integer::parseInt).toArray();
        .. process the sequence(numbers);
    }
}