public class MyPageDrawer extends PageDrawer
{

    public MyPageDrawer() throws IOException
    {
    }

    @Override
    protected void processTextPosition(TextPosition text)
    {
    }

    // taken from PDPage.convertToImage, with extra parameter and one modification
    static BufferedImage convertToImage(PDPage page, int imageType, int resolution) throws IOException
    {
        final Color TRANSPARENT_WHITE = new Color(255, 255, 255, 0);
        final int DEFAULT_USER_SPACE_UNIT_DPI = 72;

        PDRectangle cropBox = page.findCropBox();
        float widthPt = cropBox.getWidth();
        float heightPt = cropBox.getHeight();
        float scaling = resolution / (float) DEFAULT_USER_SPACE_UNIT_DPI;
        int widthPx = Math.round(widthPt * scaling);
        int heightPx = Math.round(heightPt * scaling);
        Dimension pageDimension = new Dimension((int) widthPt, (int) heightPt);
        int rotationAngle = page.findRotation();
        // normalize the rotation angle
        if (rotationAngle < 0)
        {
            rotationAngle += 360;
        }
        else if (rotationAngle >= 360)
        {
            rotationAngle -= 360;
        }
        // swap width and height
        BufferedImage retval;
        if (rotationAngle == 90 || rotationAngle == 270)
        {
            retval = new BufferedImage(heightPx, widthPx, imageType);
        }
        else
        {
            retval = new BufferedImage(widthPx, heightPx, imageType);
        }
        Graphics2D graphics = (Graphics2D) retval.getGraphics();
        graphics.setBackground(TRANSPARENT_WHITE);
        graphics.clearRect(0, 0, retval.getWidth(), retval.getHeight());
        if (rotationAngle != 0)
        {
            int translateX = 0;
            int translateY = 0;
            switch (rotationAngle)
            {
                case 90:
                    translateX = retval.getWidth();
                    break;
                case 270:
                    translateY = retval.getHeight();
                    break;
                case 180:
                    translateX = retval.getWidth();
                    translateY = retval.getHeight();
                    break;
                default:
                    break;
            }
            graphics.translate(translateX, translateY);
            graphics.rotate((float) Math.toRadians(rotationAngle));
        }
        graphics.scale(scaling, scaling);
        PageDrawer drawer = new MyPageDrawer(); // MyPageDrawer instead of PageDrawer
        drawer.drawPage(graphics, page, pageDimension);
        drawer.dispose();
        graphics.dispose();
        return retval;
    }

    public static void main(String[] args) throws IOException
    {
        String filename = "......./blah.pdf";

        // open the document
        PDDocument doc = PDDocument.loadNonSeq(new File(filename), null);
        List<PDPage> pages = doc.getDocumentCatalog().getAllPages();
        for (int p = 0; p < pages.size(); ++p)
        {
            PDPage page = pages.get(p);
            BufferedImage bim = convertToImage(page, BufferedImage.TYPE_INT_RGB, 300);

            boolean b = ImageIOUtil.writeImage(bim, "page-" + (p + 1) + ".png", 300);
            if (!b)
            {
                // error handling
            }
        }
        doc.close();
    }

}