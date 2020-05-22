public class CustomPDFDocumentHandler extends PDFDocumentHandler {

    public CustomPDFDocumentHandler(IFContext context) {
        super(context);
    }

    @Override
    public IFDocumentHandlerConfigurator getConfigurator() {
        return new CustomPDFRendererConfigurator(getUserAgent(), new PDFRendererConfigParser());
    }

}