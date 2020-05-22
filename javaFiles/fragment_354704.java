public static List<String> readDictionary(String fileName) {
    List<String> dict = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(
                new File(fileName)))) {
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.isEmpty()) {
                Stream.of(line.split("\\s+"))
                        .forEachOrdered(word -> dict.add(word));
            }
        }
    } catch (Exception e) {
        System.out.printf("Caught Exception: %s%n", e.getMessage());
        e.printStackTrace();
    }
    return dict;
}