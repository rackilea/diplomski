int countCharsSimple(File f, String charsetName) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), charsetName));
    int charCount = 0;
    while(reader.read() > -1) {
        charCount++;
    }
    reader.close();
    return charCount;
}