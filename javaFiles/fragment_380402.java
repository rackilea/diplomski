private char escapeCharacter(String data) {
    Properties p = new Properties();
    try {
        p.load(new StringReader("key=" + data));
    } catch (IOException e) {
        e.printStackTrace();
        return '\0';
    }
    return p.getProperty("key").charAt(0);
}