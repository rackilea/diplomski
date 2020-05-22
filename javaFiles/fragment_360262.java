public static void readFile(Scanner f) {
    int words = 0;
    int lines = 0;
    while (f.hasNextLine()) {
        String line = f.nextLine();
        lines++;
        for (String token : line.split("\\s+")) {
            if (!token.isEmpty()) {
                words++;
            }
        }
    }
    System.out.println("Total number of words: " + words);
    System.out.println("Total number of lines: " + lines);
}