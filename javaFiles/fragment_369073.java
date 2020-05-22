public void onEndPage(PdfWriter writer, Document document) {
    Image header = Image.getInstance("reportHeader.png");
    header.setAbsolutePosition(792, 0);
    header.scaleAbsolute(595, 50)
    writer.getDirectContent().addImage(header);
    Image footer = Image.getInstance("reportFooter.png");
    footer.setAbsolutePosition(0, 0);
    footer.scaleAbsolute(595, 50)
    writer.getDirectContent().addImage(footer);
}