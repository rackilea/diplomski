void retrieveSplash_simpler() throws IOException {
    URL url = new URL(getBaseUrl());
    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
    // open the connection
    conn.connect();
    // create a buffered reader to read the input stream line by line
    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

    // find number of threads
    String firstLine = reader.readLine();
    int x = firstLine.indexOf("[");
    int y = firstLine.indexOf("]");
    if (x > 0 && y > 0 && x < y) {
        try {
            numberOfThreads = Integer.parseInt(firstLine.substring(x+1, y));
        } catch (NumberFormatException nfe) {
            // disconnect and throw exception
            conn.disconnect();
            throw new IOException("Couldn't locate number of threads");
        }
    } else {
        // disconnect and throw exception
        conn.disconnect();
        throw new IOException("Couldn't locate number of threads");
    }

    // disconnect
    conn.disconnect();
}