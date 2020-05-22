public static void readTill(InputStream in, OutputStream out, String end) throws IOException {
    readTill(new BufferedReader(new InputStreamReader(in)), out, end);
}

public static void readTill(BufferedReader in, OutputStream out, String end) throws IOException {
    // as before
}