private static void insertBAR(PdfContentByte cb, PdfPTable table, String text, int colspan, com.itextpdf.text.Font font){
    Barcode128 code128 = new Barcode128();
    code128.setBaseline(-1);
    code128.setSize(16f);
    //code128.setBarHeight(16f);
    code128.setCode(text.trim());
    code128.setCodeType(Barcode128.CODE128);
    Image code128Image = code128.createImageWithBarcode(cb, new BaseColor(0, 47, 47), null);

    java.awt.Image awtImage = code128.createAwtImage(new Color(0, 47, 47), Color.WHITE);
    //java.awt.Image awtImage = code128.createAwtImage(Color.BLACK, Color.WHITE);
    //Initialising a 6+ (width and height)size of BufferedImage to put the Barcode Image in center
    BufferedImage bi = new BufferedImage(awtImage.getWidth(null)+6, awtImage.getHeight(null)+6, BufferedImage.TYPE_INT_ARGB);

    Graphics2D gd = bi.createGraphics();
    gd.setColor(Color.WHITE);
    gd.fillRect(0, 0, bi.getWidth(), bi.getHeight());
    //drawing the Barcode Image in center of BufferedImage Rect.
    gd.drawImage(awtImage, 3, 3, null);
    gd.dispose();

    File imgFile = new File(OneMethod.getElementosPath() + "/db/tmp/Img" + (++shortCount) + ".png");

    try {
        javaxt.io.Image img = new javaxt.io.Image(bi);
        img.saveAs(imgFile);
    code128Image = Image.getInstance(imgFile.getAbsolutePath());
    } catch (BadElementException | IOException ex) {
        ex.printStackTrace();
    }

    PdfPCell cell = new PdfPCell();
    cell.setMinimumHeight(35f);
    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    cell.setPadding(2f);
    cell.setColspan(colspan);
    cell.addElement(code128Image);
    //cell.setImage(code128Image);
    table.addCell(cell);
}