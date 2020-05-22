Path path = Paths.get("japanese.txt");
try (BufferedReader file = Files.newBufferedReader(path)) {
    String line;
    while ((line = file.readLine()) != null) {
        System.out.println(line);
    }
}