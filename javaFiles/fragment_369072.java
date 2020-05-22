public void onEndPage(PdfWriter writer, Document document) {
    Image img = Image.getInstance("reportFooter.png");
    img.setAbsolutePosition(0, 0);
    img.scaleAbsolute(595, 50)
    writer.getDirectContent().addImage(img);
}