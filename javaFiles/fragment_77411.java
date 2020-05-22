public static void main(String[] args) {
    final String filename = "database_lotto.txt";
    final File lottoFile = new File(filename);

    try (final Scanner scanner = new Scanner(lottoFile)) {
        final List<String[]> storage = new ArrayList<String[]>();
        while (scanner.hasNextLine()) {
            storage.add(scanner.nextLine().split(" "));
        }
    }catch (FileNotFoundException ex) {
        System.out.println("File not found :(");
    }
}