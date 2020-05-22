public static int countLines(File f) {
    int c = 0;
    try (Scanner s = new Scanner(f)) {
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (line.matches("^\\D+:\\d+")) {
                c++;
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    return c;
}