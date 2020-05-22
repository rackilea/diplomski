JRPdfExporter exporter = new JRPdfExporter() {
    @Override
    protected void setHyperlinkInfo(Chunk chunk, JRPrintHyperlink link) {
        if (link!=null && link.getHyperlinkTooltip() != null && HyperlinkTypeEnum.LOCAL_ANCHOR.equals(link.getHyperlinkTypeValue())) {
            PdfFormField pushButton = PdfFormField.createPushButton(pdfWriter);
            pushButton.setFieldName(String.format("tt%s", chunk.hashCode()));//Need's unique name if multiple
            Rectangle rect = new Rectangle(0, 0, 0, 0);
            pushButton.setWidget(rect, PdfAnnotation.HIGHLIGHT_NONE);
            pushButton.put(PdfName.TU, new PdfString(link.getHyperlinkTooltip(), PdfObject.TEXT_UNICODE));
            chunk.setAnnotation(pushButton);
            if (link.getHyperlinkAnchor() != null){                         
               pushButton.setAction(PdfAction.gotoLocalPage(link.getHyperlinkAnchor(), false));
            }
            return;         
        }
        super.setHyperlinkInfo(chunk, link);
    }
};