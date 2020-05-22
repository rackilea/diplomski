byte[] readIntoByteArray(URL url) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    InputStream is = url.openStream ();

    byte[] buffer = new byte[4096];
    int n;
    while ( (n = is.read(buffer)) > 0 ) {
        baos.write(bufer, 0, n);
    }

    return boas. toByteArray();
}

public BufferedImage readImage(String imageUrl) throws IOException, ImageReadException {

    /* code omitted */

    byte[] imageData = readIntoByteArray(imageUrl);
    ImageInputStream stream = ImageIO.createImageInputStream(new ByteArrayInputStream(imageData));

    /* code omitted */
}


public void checkAdobeMarker(byte[] imageData) throws IOException, ImageReadException {
    JpegImageParser parser = new JpegImageParser();
    ByteSource byteSource = new ByteSourceArray(imageData);

     /* code omitted */
}