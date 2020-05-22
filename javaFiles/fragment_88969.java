Document document = new Document();
PdfWriter.getInstance(document, new FileOutputStream("ThisIsYourPdfFile.pdf"));
document.open();
Image img = Image.getInstance("GetTheSignatureInAnImageFormat.png");
document.add(new Paragraph("Sample 1: This is where you can add text stuff say you want to add date"));
document.add(img);
document.close();