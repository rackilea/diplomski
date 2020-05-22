public static void writeFile(File file, String content) throws IOException {
    OutputStream out = new FileOutputStream(file);
    try {
        out.write(content.getBytes("UTF-8"));
    } finally {
        try {
            out.close();
        } catch (IOException ignored) {
        }
    }
}