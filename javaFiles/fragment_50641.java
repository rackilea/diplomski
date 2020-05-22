Scanner scan = new Scanner(new File("file.txt"));

List<List<List<String>>> d3 = new ArrayList<>();

while (scan.hasNextLine()) {
    String line = scan.nextLine();

    String[] splitted = line.split("(?<!\\\\)\\\"");
    List<List<String>> d2 = new ArrayList<>();
    d3.add(d2);

    List<String> d1 = new ArrayList<>();
    d2.add(d1);

    // ignore first and last
    for (int i = 1; i < splitted.length - 1; i++) {
        if ((i & 1) != 0) { // odd, add to list
            // unescape double quote and backslash
            d1.add(splitted[i].replace("\\\"", "\"").replace("\\\\", "\\"));
        } else { // even test if new array starts
            if (splitted[i].matches(".*\\{.*")) {
                d1 = new ArrayList<>();
                d2.add(d1);
            }
        }
    }
}

scan.close();
System.out.println(d3);