public class HeaderFooter extends PdfPageEventHelper {
    protected ElementList header;
    protected ElementList footer;
    public HeaderFooter() throws IOException {
        header = XMLWorkerHelper.parseToElementList(HEADER, null);
        footer = XMLWorkerHelper.parseToElementList(FOOTER, null);
    }
    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        try {
            ColumnText ct = new ColumnText(writer.getDirectContent());
            ct.setSimpleColumn(new Rectangle(36, 832, 559, 810));
            for (Element e : header) {
                ct.addElement(e);
            }
            ct.go();
            ct.setSimpleColumn(new Rectangle(36, 10, 559, 32));
            for (Element e : footer) {
                ct.addElement(e);
            }
            ct.go();
        } catch (DocumentException de) {
            throw new ExceptionConverter(de);
        }
    }
}