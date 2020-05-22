InputStream stream = new FileInputStream(location);
try {
    BufferedReader reader = new BufferedReader(new InputStreamReader(stream,
                                                                     "ASCII"));
    String line;
    while ((line = reader.readLine()) != null) {
        // Handle the line, ideally in a separate method
    }
} finally {
    stream.close();
}