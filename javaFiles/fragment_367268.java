PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
PageXofY event = new PageXofY(pdf);
pdf.addEventHandler(PdfDocumentEvent.END_PAGE, event);
Document document = new Document(pdf);
// add all the content
event.writeTotal(pdf);
document.close();