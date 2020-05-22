public static List<String> readDictionary(String fileName) {
    List<String> dict = new ArrayList<>();

    try (Scanner scan = new Scanner(new File(fileName))) {
        while (scan.hasNext()) {
            dict.add(scan.next());
        }
    } catch (Exception e) {
        System.out.printf("Caught Exception: %s%n", e.getMessage());
        e.printStackTrace();
    }
    return dict;
}