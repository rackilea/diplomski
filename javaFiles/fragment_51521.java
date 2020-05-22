public void downloadFile(String fromUrl, String localFileName) throws IOException {
    File localFile = new File(localFileName);
    if (localFile.exists()) {
        localFile.delete();
    }
    localFile.createNewFile();
    URL url = new URL(fromUrl);
    OutputStream out = new BufferedOutputStream(new FileOutputStream(localFileName));
    URLConnection conn = url.openConnection();
    String encoded = Base64.getEncoder().encodeToString(("username"+":"+"password").getBytes(StandardCharsets.UTF_8));  //Java 8
    conn.setRequestProperty("Authorization", "Basic "+ encoded);
    InputStream in = conn.getInputStream();
    byte[] buffer = new byte[1024];

    int numRead;
    while ((numRead = in.read(buffer)) != -1) {
        out.write(buffer, 0, numRead);
    }
    if (in != null) {
        in.close();
    }
    if (out != null) {
        out.close();
    }
}