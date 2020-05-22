public class FramePrintable implements Printable {

    private BufferedImage img;

    public FramePrintable(BufferedImage img) {
        this.img = img;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

        if (pageIndex == 0) {

            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            double x = (pageFormat.getImageableWidth() - img.getWidth()) / 2;
            double y = (pageFormat.getImageableHeight()- img.getHeight()) / 2;
            g2d.drawImage(img, (int)x, (int)y, null);

        }

        return pageIndex == 0 ? PAGE_EXISTS : NO_SUCH_PAGE;
    }
}