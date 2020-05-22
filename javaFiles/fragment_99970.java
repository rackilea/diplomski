File file = new File("G:/trial.txt");
char[] content = new char[(int) file.length()];
Reader reader = null;

try {
    reader = new FileReader(file);
    reader.read(content);
} finally {
    if (reader != null) try { reader.close(); } catch (IOException ignore) {}
}

return content;