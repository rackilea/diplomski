public void benchmarkListVersusMap() {
    for (int count : new int[]{1000, 5000, 10000, 20000, 30000, 50000}) {
        // Generate random sample data
        List<List<String>> words = generateData(count, 10, count);

        // Create ArrayList
        List<List<String>> list = new ArrayList<List<String>>();
        list.addAll(words);

        // Create HashMap
        Map<List<String>, Boolean> map = new HashMap<List<String>, Boolean>();
        for (List<String> row : words) {
            map.put(row, true);
        }

        // Measure:
        long timer = System.currentTimeMillis();
        for (List<String> row: words) {
            if (list.contains(row)) {
                list.remove(row);
            }
        }
        long listTime = System.currentTimeMillis() - timer;
        timer = System.currentTimeMillis();
        for (List<String> row : words) {
            if (map.containsKey(row)) {
                map.remove(row);
            }
        }
        long mapTime = System.currentTimeMillis() - timer;
        System.out.printf("For %s words: List: %s ms, Map: %s ms\n", count, listTime, mapTime);
    }
}

private List<List<String>> generateData(int rows, int cols, int noOfDifferentWords) {
    List<List<String>> list = new ArrayList<List<String>>(rows);
    List<String> dictionary = generateRandomWords(noOfDifferentWords);
    Random rnd = new Random();
    for (int row = 0; row < rows; row++) {
        List<String> l2 = new ArrayList<String>(cols);
        for (int col = 0; col < cols; col++) {
            l2.add(dictionary.get(rnd.nextInt(noOfDifferentWords)));
        }
        list.add(l2);
    }
    return list;
}

private static final String CHARS = "abcdefghijklmnopqrstuvwxyz0123456789";
private List<String> generateRandomWords(int count) {
    Random rnd = new Random();
    List<String> list = new ArrayList<String>(count);
    while (list.size() < count) {
        StringBuilder sb = new StringBuilder(20);
        for (int i = 0; i < 10; i++) {
            sb.append(CHARS.charAt(rnd.nextInt(CHARS.length())));
        }
        list.add(sb.toString());
    }
    return list;
}