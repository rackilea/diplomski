Scanner sc = new Scanner(new File("file.txt")); // default delimiter is whitespace
/**
 * or if using a custom delimiter:
 * final String DELIMITER = " "; // using space
 * Scanner sc = new Scanner("file.txt").useDelimiter(DELIMITER);
 */
List<String> items = new ArrayList<>();
while (sc.hasNext()) {
    items.add(sc.next());
}

for (String item : items) { // test output
    System.out.println(item);
}