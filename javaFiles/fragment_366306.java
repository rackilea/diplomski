public static String getContents(File aFile) throws IOException {
    BufferedReader rdr = new BufferedReader(new FileReader("aFile"));
    try {
        StringBuilder sb = new StringBuilder();
        // read your lines
        return sb.toString();
    } finally {
        rdr.close();
    }
}