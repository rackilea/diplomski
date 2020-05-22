public class CustomPDFRendererConfigurator extends PDFRendererConfigurator {

    public CustomPDFRendererConfigurator(FOUserAgent userAgent, RendererConfigParser rendererConfigParser) {
        super(userAgent, rendererConfigParser);
    }

    @Override
    protected FontCollection getCustomFontCollection(InternalResourceResolver resolver, String mimeType)
            throws FOPException {

        List<EmbedFontInfo> fontList = new ArrayList<EmbedFontInfo>();
        try {
            FontUris fontUris = new FontUris(Thread.currentThread().getContextClassLoader().getResource("UbuntuMono-Bold.ttf").toURI(), null);
            List<FontTriplet> triplets = new ArrayList<FontTriplet>();
            triplets.add(new FontTriplet("UbuntuMono", Font.STYLE_NORMAL, Font.WEIGHT_NORMAL));
            EmbedFontInfo fontInfo = new EmbedFontInfo(fontUris, false, false, triplets, null, EncodingMode.AUTO, EmbeddingMode.AUTO);
            fontList.add(fontInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return createCollectionFromFontList(resolver, fontList);
    }

}