PdfReader reader = new PdfReader(resource);
PdfDocument pdfDocument = new PdfDocument(reader, new PdfWriter(outputStream));
PdfAcroForm acroForm = PdfAcroForm.getAcroForm(pdfDocument, false);

PdfFormField testField = acroForm.getField("test");
testField.setValue("My test text...");

acroForm.flattenFields();

pdfDocument.close();