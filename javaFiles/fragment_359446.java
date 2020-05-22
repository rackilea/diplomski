public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
        throws PrinterException {

    // setup
    super.printSetup(graphics, pageFormat);

    // title
    super.setFont(new Font("Tahoma", Font.BOLD, 16));
    y = super.drawParagraph(event.getTitle(), imageWidth, x, y, Alignment.LEFT);

    RETURN PAGE_EXISTS;                 
}