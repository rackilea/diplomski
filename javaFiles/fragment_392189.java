ByteArrayOutputStream baos = new ByteArrayOutputStream();
HtmlConverter.convertToPdf(new FileInputStream("C:\\file.html"), baos,
        new ConverterProperties().setCreateAcroForm(true));

PdfDocument document = new PdfDocument(new PdfReader(new ByteArrayInputStream(baos.toByteArray())), 
        new PdfWriter(new File("C:\\out.pdf")));
PdfAcroForm acroForm = PdfAcroForm.getAcroForm(document, false);
acroForm.flattenFields();
document.close();