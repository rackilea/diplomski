public int countChars3(String fileName) throws IOException {
    int total = 0;
    FileReader reader = new FileReader(fileName);
    try {
        while (reader.ready()) {
            reader.read();
            total++;
        }
        reader.close();
    } finally {
        reader.close();
    }
    return total;
}