public class CustomPDFDocumentHandlerMaker extends PDFDocumentHandlerMaker {

    @Override
    public IFDocumentHandler makeIFDocumentHandler(IFContext ifContext) {
        CustomPDFDocumentHandler handler = new CustomPDFDocumentHandler(ifContext);
        FOUserAgent ua = ifContext.getUserAgent();
        if (ua.isAccessibilityEnabled()) {
            ua.setStructureTreeEventHandler(handler.getStructureTreeEventHandler());
        }
        return handler;
    }

}