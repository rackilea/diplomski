public class SVGImage extends xom.nu.Element {
    private static final String DATA = "data";
    private static final String BASE64 = "base64";
    public static final String IMAGE_PNG = "image/png";
    public static final String PNG = "PNG";

    private static final String XLINK_PREF = "xlink";
    private static final String HREF = "href";
    private static final String XLINK_NS = "http://www.w3.org/1999/xlink";

        public void readImageData(BufferedImage bufferedImage, String mimeType) {
    String type = mimeType2ImageTypeMap.get(mimeType);
    if (type == null) {
        throw new RuntimeException("Cannot convert mimeType: "+mimeType);
    }
    double x = bufferedImage.getMinX();
    double y = bufferedImage.getMinY();
    double height = bufferedImage.getHeight();
    double width = bufferedImage.getWidth();
    this.setX(x);
    this.setY(y);
    this.setWidth(width);
    this.setHeight(height);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try {
        ImageIO.write(bufferedImage, type, baos);
    } catch (IOException e) {
        throw new RuntimeException("Cannot read image", e);
    }
    byte[] byteArray = baos.toByteArray();
    String base64 = Base64.encode(byteArray);
    String attValue = DATA+":"+mimeType+";"+BASE64+","+base64;
    this.addAttribute(new Attribute(XLINK_PREF+":"+HREF, XLINK_NS, attValue));
    }
}