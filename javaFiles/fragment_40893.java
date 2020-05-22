public Image getWatermarkedImage(PdfContentByte cb, Image img, String watermark) throws DocumentException {
    float width = img.getScaledWidth();
    float height = img.getScaledHeight();
    PdfTemplate template = cb.createTemplate(width, height);
    template.addImage(img, width, 0, 0, height, 0, 0);
    ColumnText.showTextAligned(template, Element.ALIGN_CENTER,
            new Phrase(watermark, FONT), width / 2, height / 2, 30);
    return Image.getInstance(template);
}