public static void writeChanges(String changes, int whichLine) throws IOException {
    // The files we're working with
    final File database = new File("database.txt");
    final File newDatabase = new File("database.new.txt");
    try(BufferedReader reader = new Bufferedreader(
            new InputStreamReader(new FileInputStream(database)));
            PrintWriter writer = new PrintWriter(newDatabase)) {
        int line = 0;
        String line;
        // Keep reading lines from the source file until we've read them all
        while((line = reader.readLine()) != null) {
            if(line == whichLine) {
                // Write the modified line
                writer.println(changes);
            } else {
                // Write the original line
                writer.println(line);
            }
            line++;
        }
    }
    // Replace the old database with the new
    Files.move(newDatabase.toPath(), database.toPath(), StandardCopyOption.REPLACE_EXISTING);
}