public static String doHTTPGet(String urlString) throws IOException{
    URL weatherAPI = new URL(urlString);
    HttpURLConnection apiConnection = (HttpURLConnection) weatherAPI.openConnection();
    apiConnection.setRequestMethod("GET");
    apiConnection.setRequestProperty("Accept-Encoding", "gzip");

    apiConnection.connect();

    InputStream gzippedResponse = apiConnection.getInputStream();
    InputStream decompressedResponse = new GZIPInputStream(gzippedResponse);
    Reader reader = new InputStreamReader(decompressedResponse, "UTF-8");
    StringWriter writer = new StringWriter();

    char[] buffer = new char[10240];
    for(int length = 0; (length = reader.read(buffer)) > 0;){
        writer.write(buffer, 0, length);
    }

    writer.close();
    reader.close();
    decompressedResponse.close();
    gzippedResponse.close();
    apiConnection.disconnect();

    return writer.toString();
}