public class TestOrientation {
    public static void D() throws Exception {

        TessAPI api=LoadLibs.getTessAPIInstance();
        TessBaseAPI handle=TessAPI1.TessBaseAPICreate();

        File tiff = new File("C:/Users/atul/Desktop/test1.tif");
        String datapath = "C:/Tesseract/tessdata";
        String language = "eng";
        int expResult = TessPageSegMode.PSM_AUTO_OSD;
        IntBuffer orientation = IntBuffer.allocate(1);
        IntBuffer direction = IntBuffer.allocate(1);
        IntBuffer order = IntBuffer.allocate(1);
        FloatBuffer deskew_angle = FloatBuffer.allocate(1);

        BufferedImage image = ImageIO.read(new FileInputStream(tiff)); // require jai-imageio lib to read TIFF
        ByteBuffer buf = ImageIOHelper.convertImageData(image);
        int bpp = image.getColorModel().getPixelSize();
        int bytespp = bpp / 8;
        int bytespl = (int) Math.ceil(image.getWidth() * bpp / 8.0);
        api.TessBaseAPIInit3(handle, datapath, language);
        api.TessBaseAPISetPageSegMode(handle, TessPageSegMode.PSM_AUTO_OSD);
        int actualResult = api.TessBaseAPIGetPageSegMode(handle);

        api.TessBaseAPISetImage(handle, buf, image.getWidth(), image.getHeight(), bytespp, bytespl);
        int success = api.TessBaseAPIRecognize(handle, null);
        if (success == 0) {
            TessPageIterator pi = api.TessBaseAPIAnalyseLayout(handle);
            api.TessPageIteratorOrientation(pi, orientation, direction, order, deskew_angle);
            System.out.println("Orientation:" + orientation.get()+
                "\nWritingDirection:"+Utils.getConstantName(direction.get(), TessWritingDirection.class)+
                " \nTextlineOrder:" + Utils.getConstantName(order.get(), TessTextlineOrder.class)+
                "\nDeskew angle: %.4f\n"+deskew_angle.get());
        }
    }

    public static void main(String[] args) {
        try {
            D();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}