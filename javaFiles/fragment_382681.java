public class PrintTest02 {

    private static BufferedImage image;

    public static void main(String[] args) {
        try {
            image = ImageIO.read(new File("/path/to/image.png"));

            System.out.println(image.getWidth() + "x" + image.getHeight());

            PrinterJob pj = PrinterJob.getPrinterJob();
            if (pj.printDialog()) {
                PageFormat pf = pj.defaultPage();
                Paper paper = pf.getPaper();
//                        86X54mm
                double width = fromCMToPPI(8.6);
                double height = fromCMToPPI(5.4);
                paper.setSize(width, height);
                paper.setImageableArea(
                                fromCMToPPI(0.1),
                                fromCMToPPI(0.1),
                                width - fromCMToPPI(0.1),
                                height - fromCMToPPI(0.1));
                pf.setOrientation(PageFormat.PORTRAIT);
                pf.setPaper(paper);
                PageFormat validatePage = pj.validatePage(pf);
                System.out.println("Valid- " + dump(validatePage));
                pj.setPrintable(new MyPrintable(), validatePage);
                try {
                    pj.print();
                } catch (PrinterException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    protected static double fromPPItoCM(double dpi) {
        return dpi / 72 / 0.393700787;
    }

    protected static double fromCMToPPI(double cm) {
        return toPPI(cm * 0.393700787);
    }

    protected static double toPPI(double inch) {
        return inch * 72d;
    }

    protected static String dump(Paper paper) {
        StringBuilder sb = new StringBuilder(64);
        sb.append(paper.getWidth()).append("x").append(paper.getHeight())
                        .append("/").append(paper.getImageableX()).append("x").
                        append(paper.getImageableY()).append(" - ").append(paper
                        .getImageableWidth()).append("x").append(paper.getImageableHeight());
        return sb.toString();
    }

    protected static String dump(PageFormat pf) {
        Paper paper = pf.getPaper();
        return dump(paper);
    }

    public static class MyPrintable implements Printable {

        @Override
        public int print(Graphics graphics, PageFormat pageFormat,
                                         int pageIndex) throws PrinterException {
            System.out.println(pageIndex);
            int result = NO_SUCH_PAGE;
            if (pageIndex < 1) {
                Graphics2D g2d = (Graphics2D) graphics;
                System.out.println("[Print] " + dump(pageFormat));
                double width = pageFormat.getImageableWidth();
                double height = pageFormat.getImageableHeight();

                System.out.println("Print Size = " + fromPPItoCM(width) + "x" + fromPPItoCM(height));
                g2d.translate((int) pageFormat.getImageableX(),
                                (int) pageFormat.getImageableY());
                Image scaled = null;
                if (width > height) {
                    scaled = image.getScaledInstance((int)Math.round(width), -1, Image.SCALE_SMOOTH);
                } else {
                    scaled = image.getScaledInstance(-1, (int)Math.round(height), Image.SCALE_SMOOTH);
                }
                g2d.drawImage(scaled, 0, 0, null);
                result = PAGE_EXISTS;
            }
            return result;
        }

    }

}