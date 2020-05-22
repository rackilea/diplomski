int countCharsBuffer(File f, String charsetName) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), charsetName));
    int charCount = 0;
    char[] cbuf = new char[1024];
    int read = 0;
    while((read = reader.read(cbuf)) > -1) {
        charCount += read;
    }
    reader.close();
    return charCount;
}