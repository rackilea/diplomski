public class MyBarcodeGenerator {
  public static Image getGS1_128(String code) {
    if (code==null){
        return null;
    }
    EAN128Bean c = new EAN128Bean();
    c.setChecksumMode(ChecksumMode.CP_AUTO);
    c.setOmitBrackets(false);
    c.setCodeset(Code128Constants.CODESET_C);
    c.setMsgPosition(HumanReadablePlacement.HRP_BOTTOM);
    c.doQuietZone(true);
    c.setQuietZone(5);
    c.setFontSize(2d);

    int dpi = 200;
    boolean antiAlias = false;
    int orientation = 0;
    BitmapCanvasProvider canvas = new BitmapCanvasProvider(dpi, BufferedImage.TYPE_BYTE_BINARY, antiAlias, orientation);
    c.generateBarcode(canvas, code);
    return canvas.getBufferedImage();
  }
}