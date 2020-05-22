public static void myfunc(String filename) throws IOException {
    FileInputStream stream = null;
    try {
        stream = new FileInputStream(filename);
        ...
    } finally {
        stream.close();
    }
}