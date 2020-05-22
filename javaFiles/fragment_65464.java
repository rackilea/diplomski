public class PdfEarningsRecordView extends AbstractPdfView {

@Override
protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

    HelperClass helper = new HelperClass(getMessageSourceAccessor());