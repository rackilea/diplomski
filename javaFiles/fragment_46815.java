public int getNumberOfPages(Printable delegate, PageFormat pageFormat) throws PrinterException {
    Graphics g = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB).createGraphics();
    int numPages = 0;
    while (true) {
        int result = delegate.print(g, pageFormat, numPages);
        if (result == Printable.PAGE_EXISTS) {
            ++numPages;
        } else {
            break;
        }
    }

    return numPages;
}