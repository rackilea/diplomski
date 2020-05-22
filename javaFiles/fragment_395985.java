//Open document
Document pdfDocument = new Document("Input.pdf");

//Create a field
SignatureField signatureField = new SignatureField(pdfDocument.getPages().get_Item(1), new com.aspose.pdf.Rectangle(100, 200, 300, 300));
signatureField.setPartialName("signature1");

//Add field to the document
pdfDocument.getForm().add(signatureField, 1);

//Save modified PDF
pdfDocument.save("Output.pdf");