private String getAttachmentContent(String attachmentURL) throws IBSharePointException {
    InputStream inputStream = null;
    URLConnection urlConnection = null;
    URL url = null;
    ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
    byte[] byteChunk = new byte[4096];
    int noOfBytes = 0;
    try {

        String fileName = attachmentURL.substring(attachmentURL.lastIndexOf("/") + 1);
        String urlPath = attachmentURL.substring(0, attachmentURL.lastIndexOf("/") + 1);
        fileName = URLEncoder.encode(fileName, "UTF-8");
        //This line is to fix bug # 966837
        if (fileName.contains("+"))
            fileName = fileName.replace("+", "%20");

        url = new URL(urlPath + fileName);
        urlConnection = url.openConnection();
        urlConnection.addRequestProperty("User-Agent", _Constants.DEFAULT_USER_AGENT_WINDOWS);
        // We need to set cookies as below.
        urlConnection.addRequestProperty("Cookie", _mSharePointSession.cookieNedToken);

        urlConnection.connect();

        inputStream = urlConnection.getInputStream();

        while ((noOfBytes = inputStream.read(byteChunk)) > 0) {
            byteOutputStream.write(byteChunk, 0, noOfBytes);
        }

        return new BASE64Encoder().encode(byteOutputStream.toByteArray());

    } catch (Exception e) {
        throw e;
    }
}