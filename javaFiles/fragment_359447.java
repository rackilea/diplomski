public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
        throws PrinterException {
    int result = NO_SUCH_PAGE;
    if (pageIndex == 0) {

        // setup
        super.printSetup(graphics, pageFormat);

        // title
        super.setFont(new Font("Tahoma", Font.BOLD, 16));
        y = super.drawParagraph(event.getTitle(), imageWidth, x, y, Alignment.LEFT);
        result = PAGE_EXISTS;
    }

    RETURN result;                 
}