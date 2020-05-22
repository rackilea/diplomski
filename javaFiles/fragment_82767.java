public void createBase64String(InputStream in) throws IOException {
    baos = new ByteArrayOutputStream();
    byte[] buf = new byte[BUFFER_SIZE];
    int readNum = 0;
    smtp.addBase64("\t\t");

    try {
        while ((readNum = in.read(buf)) >= 0) {
            baos.write(buf, 0, readNum);
            smtp.addBase64(baos.toString());
            baos.reset();
        }
    }
    catch (IOException ex) {
        LogUtil.error("Sending of Base64 String to SMTP: IOException: " + ex);
    }
    finally {
        if (in != null) {
            in.close();
            baos.close();
        }
    }

    baos = null;
    buf = null;
}