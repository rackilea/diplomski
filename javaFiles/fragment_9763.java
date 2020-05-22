File file = new File(fileName);
try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    String line;
    int rows = 0;
    int cols = 0;
    while ((line = br.readLine()) != null) {
        // process the line
        rows++;
        cols = line.length(); // always the size of the last line in the file
    }
}
br.close();