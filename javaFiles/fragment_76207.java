public static void main(String[] args) throws IOException{
    downloadFunction("http://google.com.vn",
            "/tmp/google.html", "someHeaderValue");
}

private static void downloadFunction(String url, String outPut, String headerValue) throws IOException{
    URL website = new URL(url);
    URLConnection connection = website.openConnection();
    connection.setRequestProperty("headerKey", headerValue);
    InputStream response = connection.getInputStream();
    ReadableByteChannel rbc = Channels.newChannel(response);
    FileOutputStream fos = new FileOutputStream(outPut);
    fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
}