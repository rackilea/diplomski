public static void printCard(final String name, final String lName, final Image mainImage){

    Printable contentToPrint = new Printable(){
        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int page) throws PrinterException {
            if (page > 0) {
                return NO_SUCH_PAGE;
            }
            pageFormat.setOrientation(PageFormat.PORTRAIT);
            graphics.drawImage(mainImage, 0, 0, null);
            graphics.drawString(lName, 100, 300);
            graphics.drawString(name, 100, 100);

            return PAGE_EXISTS;
        }
    };

    PrinterJob job = PrinterJob.getPrinterJob();
    job.setPrintable(contentToPrint);
    //You can show a print dialog before printing by job by wrapping the following blocks with a conditional statement if(job.printDialog()){...}
    try {
        job.print();
    } catch (PrinterException e) {
        System.err.println(e.getMessage());
    }

}