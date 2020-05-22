documentString = [...your base64 encoded PDF ...];
byte[] decodedPdfDocument = Base64.decode(documentString);
...
PDDocument document = PDDocument.load(decodedPdfDocument);
PDFTextStripper textStripper = new PDFTextStripper();
String st = textStripper.getText(document);