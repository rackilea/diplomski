public static void read(String str) throws IOException {
    FileInputStream stream = null
    try {
        stream = new FileInputStream(str);
        readStreamToConsole(stream);
    } finally {
        if (stream != null)
            stream.close();
    }
}

private static void readStreamToConsole(InputStream stream) {
    BufferedReader stdOut = new BufferedReader(new InputStreamReader(stream));
    String output = null;
    while ((output = stdOut.readLine()) != null)
        System.out.println(output);
}