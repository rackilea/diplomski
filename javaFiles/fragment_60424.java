//Starting a new pdf document
Document document = new Document();
ByteArrayOutputStream os = new ByteArrayOutputStream();

//This is your new pdf doc
PdfWriter writer = PdfWriter.getInstance(document, os);

document.open();
document.newPage();

//Get the file of you template, you should use try catch and then close it
//I simply to just show sistem
FileInputStream template = new FileInputStream("template.pdf");

//Load it into a reader
PdfReader reader = new PdfReader(template);

//Get the page of the template you like
PdfImportedPage page = writer.getImportedPage(reader, 1);

//Now you can add it to you report
PdfContentByte cb = writer.getDirectContent();
cb.addTemplate(page, 0, 0);

//Here goes code of other stuff that you add..