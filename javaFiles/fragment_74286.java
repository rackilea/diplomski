URL url = new URL(urlString);
HttpURLConnection con = (HttpURLConnection) url.openConnection();
// we're not really connected now. Just the connection object has been created
// here you can set additional request properties (e.g. request headers)
con.connect();
// now we are connected!
if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
    try (InputStream entityStream = con.getInputStream()) {
        InputStream is;
        if ("gzip".equals(con.getContentEncoding())) {
            is = new GZIPInputStream(entityStream); // wrap
        } else {
            is = entityStream;
        }

        reader.parse(new InputSource(is));
    }
} else {
    // handle HTTP response code != OK
}
con.disconnect();