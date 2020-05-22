Rectangle linkLocation2x = new Rectangle(150, 470, 30, 90);
PdfAnnotation link2x = new PdfRedactAnnotation(linkLocation2x)
        .setColor(ColorConstants.BLACK.getColorValue());
PdfFormXObject formN = new PdfFormXObject(linkLocation2x);
PdfCanvas canvasN = new PdfCanvas(formN, pdfDoc);
canvasN.setFillColorGray(1)
       .rectangle(linkLocation2x.getX(), linkLocation2x.getY(), linkLocation2x.getWidth(), linkLocation2x.getHeight())
       .fill();
link2x.setNormalAppearance(formN.getPdfObject());
link2x.setFlag(PdfAnnotation.PRINT);
pdfDoc.getFirstPage().addAnnotation(link2x);

Rectangle linkLocation3x = new Rectangle(150, 370, 90, 30);
PdfAnnotation stamp1x = new PdfStampAnnotation(linkLocation3x)
        .setStampName(new PdfName("Confidential"))
        .setContents("Landscape").setColor(ColorConstants.BLACK.getColorValue());
formN = new PdfFormXObject(linkLocation3x);
canvasN = new PdfCanvas(formN, pdfDoc);
canvasN.setFillColorGray(1)
       .rectangle(linkLocation3x.getX(), linkLocation3x.getY(), linkLocation3x.getWidth(), linkLocation3x.getHeight())
       .fill();
stamp1x.setNormalAppearance(formN.getPdfObject());
stamp1x.setFlag(PdfAnnotation.PRINT);
pdfDoc.getFirstPage().addAnnotation(stamp1x);