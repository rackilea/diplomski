//Class that creates the PDF
public class PdfCreator {

//Helper class so we can add colour to our pages when we call it from outer class
private static class PageBackgroundsEvent implements IEventHandler {
    @Override
    public void handleEvent(Event event) {
        PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
        PdfPage page = docEvent.getPage();

        PdfCanvas canvas = new PdfCanvas(page);
        Rectangle rect = page.getPageSize();
        //I used custom rgb for Color
        Color bgColour = new DeviceRgb(255, 204, 204);
        canvas  .saveState()
                .setFillColor(bgColour)
                .rectangle(rect.getLeft(), rect.getBottom(), rect.getWidth(), rect.getHeight())
                .fillStroke()
                .restoreState();
        }
    }

    //PATH_OF_FILE is the path that the PDF will be created at.
    String filename = PATH_OF_FILE + "/myFile.pdf";
    OutputStream outputStream = new FileOutputStream(new File(filename));
    PdfWriter writer = new PdfWriter(outputStream);
    PdfDocument pdfDoc = new PdfDocument(writer);
    pdfDoc.addEventHandler(PdfDocumentEvent.START_PAGE, new PageBackgroundsEvent());
    PageSize pageSize = pdfDoc.getDefaultPageSize();
    Document document = new Document(pdfDoc, pageSize);
    document.close();
}