public static void parseFile(String s) throws IOException {
        File file = new File("data.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            final String lineFromFile = scanner.nextLine();
            if (lineFromFile.contains(s)) {
                System.out.println(scanner.nextLine());  // code hangs right here.
            }
        }
    }