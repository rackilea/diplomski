public static void main (String args[]) throws IOException {
    WebClient client = new WebClient(BrowserVersion.FIREFOX_3_6);
    UnexpectedPage imagePage = client.getPage("http://i.stack.imgur.com/9DdHc.jpg");
    BASE64Encoder encoder = new BASE64Encoder();
    String base64data = encoder.encode(inputStreamToByteArray(imagePage.getWebResponse().getContentAsStream()));
    System.out.println("<img src=\"data:image/png;base64,"+base64data.replaceAll("\r?\n","")+"\" />");
}

private static byte[] inputStreamToByteArray(InputStream is) throws IOException {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    int nRead;
    byte[] data = new byte[16384];
    while ((nRead = is.read(data, 0, data.length)) != -1) {
        buffer.write(data, 0, nRead);
    }
    buffer.flush();
    return buffer.toByteArray();
}