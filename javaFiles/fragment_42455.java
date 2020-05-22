public int print(Graphics g, PageFormat format, int index) throws PrinterException {
        int pagenum = index + 1;
        if ((pagenum >= 1) && (pagenum <= file.getNumPages())) {
            Graphics2D g2 = (Graphics2D) g;
            PDFPage page = file.getPage(pagenum);

            // fit the PDFPage into the printing area
            Rectangle imageArea = new Rectangle((int) format.getImageableX(), (int) format.getImageableY(),
                    (int) format.getImageableWidth(), (int) format.getImageableHeight());
            g2.translate(0, 0);
            PDFRenderer pgs = new PDFRenderer(page, g2, imageArea, null, null);
            try {
                page.waitForFinish();
                pgs.run();
            } catch (InterruptedException ie) {
                // nothing to do
            }
            return PAGE_EXISTS;
        } else {
            return NO_SUCH_PAGE;
        }
    }