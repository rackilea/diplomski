String readFile(String file) throws IOException {
    FileReader fr = new FileReader(new File(file));
    String s = "";
    int c;
    while ((c = fr.read()) >= 0) {
        s += (c == '\n' ? myCharOrString : (char)c;
    }
    return s;
}