public static void main(String[] args) throws IOException, COSVisitorException
{
    PDDocument document = new PDDocument();
    pdlog("Create First Page", "b", document);
    pdlog("add more page", "b", document);
    pdlog("close pdf", "b", document);
}

public static void pdlog(String action, String msg, PDDocument document) throws IOException, COSVisitorException
{
    //Master PDF Log File --------------------------------------------------------------------
    String masterPDLog = "X:\\eHub\\QA\\eHub_Automation_Log.pdf";
    // Create a document and add a page to it
    PDPage page = new PDPage(PDPage.PAGE_SIZE_A4);

    if (action.equals("Create First Page"))
    {
        document.addPage(page);
        // Create a new font object selecting one of the PDF base fonts
        PDFont font = PDType1Font.TIMES_ROMAN;
        PDFont boldFont = PDType1Font.TIMES_BOLD;
        //File for CTS Logo --------------------
        InputStream in = new FileInputStream(new File("X:\\eHub\\QA\\img\\cts.jpg"));
        PDJpeg img = new PDJpeg(document, in);

        // Start a new content stream which will "hold" the to be created content
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

            //Place CTS Logo
        //contentStream.drawImage(img, 500, 750);
        contentStream.drawXObject(img, 450, 700, 50, 50);

        // Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
        contentStream.beginText();
        contentStream.setFont(boldFont, 20);
        contentStream.setNonStrokingColor(Color.BLUE);
        contentStream.moveTextPositionByAmount(120, 650);
        contentStream.drawString("eHub Automated Data Quality Report");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(boldFont, 20);
        contentStream.setNonStrokingColor(Color.BLUE);
        contentStream.moveTextPositionByAmount(140, 600);
        contentStream.drawString("Data Profiling/Quality/Analysis");
        contentStream.endText();
        // Make sure that the content stream is closed:
        contentStream.close();
        //document.save(masterPDLog);

        System.out.println("1ST PAGE ADDED");

    }
    else if (action.equals("add more page"))
    {
        PDFont font = PDType1Font.TIMES_ROMAN;
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(font, 20);
        contentStream.setNonStrokingColor(Color.BLACK);
        contentStream.moveTextPositionByAmount(100, 800);
        contentStream.drawString("eHub Automated Data Quality Report");
        contentStream.endText();
        contentStream.close();

        //document.save(masterPDLog);
        System.out.println("2ND PAGE ADDED");
    }
    else if (action.equals("close pdf"))
    {
        PDFont font = PDType1Font.TIMES_ROMAN;

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(font, 20);
        contentStream.setNonStrokingColor(Color.BLACK);
        contentStream.moveTextPositionByAmount(100, 800);
        contentStream.drawString("eHub Automated Data Quality Report");
        contentStream.endText();
        contentStream.close();

        document.save(masterPDLog);
        document.close();
        System.out.println("PDF CLOSED");
    }
}