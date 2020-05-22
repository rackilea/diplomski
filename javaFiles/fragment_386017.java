String readFile(String file, int bufferSize) throws IOException {
    FileReader fr = new FileReader(new File(file));
    char[] buffer = new char[bufferSize];
    int charsRead;
    String s = "";
    while ((charsRead = fr.read(buffer)) > 0) {
        s += new String(buffer, 0, charsRead);
    }
    return s.replaceAll("\\r\\n?", "\n");
}