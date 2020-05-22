// Create output PDF
Document document = new Document(PageSize.A4);
PdfWriter writer = PdfWriter.getInstance(document, outputStream);
document.open();
PdfContentByte cb = writer.getDirectContent();

// Load existing PDF
PdfReader reader = new PdfReader(templateInputStream);
PdfImportedPage page = writer.getImportedPage(reader, 1); 

// Copy first page of existing PDF into output PDF
document.newPage();
cb.addTemplate(page, 0, 0);

// Add your new data / text here
// for example...
document.add(new Paragraph("my timestamp")); 

document.close();