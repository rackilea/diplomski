public static void main(String[] args) throws IOException, PrinterException {
    if (args.length != 1) {
        System.err.println("The first parameter must have the location of the PDF file to be printed");
    }

    FileInputStream fis = new FileInputStream(new File("x.pdf"));//file path

    PrintPdf printPDFFile = new PrintPdf(fis, "Test Print PDF");
    printPDFFile.print();
}

public static PrintService setPrintService(String argPrintServiceName) throws PrinterException {
    PrintService psr = null;
    PrintService[] printServices = PrinterJob.lookupPrintServices();
    int i;
    for (i = 0; i < printServices.length; i++) {
        if (printServices[i].getName().equalsIgnoreCase(argPrintServiceName)) {
            psr = printServices[i];
            break;
        }
    }
    if (i == printServices.length) {
        throw new PrinterException("Invalid print service name: " + argPrintServiceName);
    }
    return psr;
}

/**
 * Constructs the print job based on the input stream
 *
 * @param inputStream
 * @param jobName
 * @throws IOException
 * @throws PrinterException
 */
public PrintPdf(InputStream inputStream, String jobName) throws IOException, PrinterException {
    byte[] pdfContent = new byte[inputStream.available()];
    inputStream.read(pdfContent, 0, inputStream.available());
    initialize(pdfContent, jobName);
}

/**
 * Initializes the job
 *
 * @param pdfContent
 * @param jobName
 * @throws IOException
 * @throws PrinterException
 */
private void initialize(byte[] pdfContent, String jobName) throws IOException, PrinterException {
    ByteBuffer bb = ByteBuffer.wrap(pdfContent);
    /* Create PDF Print Page*/
    PDFFile pdfFile = new PDFFile(bb);
    PDFPrintPage pages = new PDFPrintPage(pdfFile);

    /* Create Print Job  */
    pjob = PrinterJob.getPrinterJob();
    pf = PrinterJob.getPrinterJob().defaultPage();

    pf.setOrientation(PageFormat.PORTRAIT);
    pjob.setJobName(jobName);

    Book book = new Book();
    book.append(pages, pf, pdfFile.getNumPages());
    pjob.setPageable(book);

    /* to remove margins  */
    Paper paper = new Paper();
    paper.setImageableArea(0, 0, paper.getWidth(), paper.getHeight());

    pf.setPaper(paper);
}

public void print() throws PrinterException {
    // Send print job to default printer
    pjob.print();
}

/**
 * Class that actually converts the PDF file into Printable format
 */
class PDFPrintPage implements Printable {

    private PDFFile file;

    PDFPrintPage(PDFFile file) {
        this.file = file;
    }

    public int print(Graphics g, PageFormat format, int index) throws PrinterException {
        int pagenum = index + 1;
        if ((pagenum >= 1) && (pagenum <= file.getNumPages())) {
            Graphics2D g2 = (Graphics2D) g;
            PDFPage page = file.getPage(pagenum);

            // fit the PDFPage into the printing area
            Rectangle imageArea = new Rectangle((int) format.getImageableX(),(int)format.getImageableY(),(int) format.getImageableWidth(), (int) format.getImageableHeight());
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

}