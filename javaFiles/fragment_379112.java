public byte[] getResponse(String server_url, String request) throws IOException {
    URLConnection urlConnection = null;
    try {
        URL url = new URL(server_url);
        urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);
        // Set headers
        urlConnection.setRequestProperty("content-type", "text/xml; charset=".concat("UTF-8"));
        urlConnection.setRequestProperty("User-Agent", "Olap4j");
        urlConnection.setRequestProperty("Accept", "text/xml;q=1");
        urlConnection.setRequestProperty("Accept-Charset", "UTF-8;q=1");
        urlConnection.setRequestProperty("Accept-Encoding", "gzip"); // Tell the server that we support gzip encoding
        // Some servers expect a SOAPAction header.
        if (request.contains("DISCOVER")) {
            urlConnection.setRequestProperty("SOAPAction", "\"urn:schemas-microsoft-com:xml-analysis:Discover\"");
        } else if (request.contains("EXECUTE")) {
            urlConnection.setRequestProperty("SOAPAction", "\"urn:schemas-microsoft-com:xml-analysis:Execute\"");
        }
        // Send data (i.e. POST). Use same encoding as specified in the
        // header.
        final String encoding1 = "UTF-8";
        urlConnection.getOutputStream().write(request.getBytes(encoding1));
        // Get the response, again assuming default encoding.
        InputStream is = urlConnection.getInputStream();
        // Detect that the server used gzip encoding
        String contentEncoding =
                urlConnection.getHeaderField("Content-Encoding");
        if ("gzip".equals(contentEncoding)) {
            is = new GZIPInputStream(is);
        }
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int count;
        while ((count = is.read(buf)) > 0) {
            baos.write(buf, 0, count);
        }
        return baos.toByteArray();
    } catch (Exception e) {
        // In order to prevent the JDK from keeping this connection
        // in WAIT mode, we need to empty the error stream cache.
        final int espCode =
                ((HttpURLConnection) urlConnection).getResponseCode();
        InputStream errorStream =
                ((HttpURLConnection) urlConnection).getErrorStream();
        final ByteArrayOutputStream baos =
                new ByteArrayOutputStream();
        final byte[] buf = new byte[1024];
        int count;
        if (errorStream != null) {
            while ((count = errorStream.read(buf)) > 0) {
                baos.write(buf, 0, count);
            }
            errorStream.close();
        }
        baos.close();
    }
    return null;
}