public void buildSignature() throws IOException
{
    PDFTemplateBuilder builder = new PDVisibleSigBuilder();
    PDFTemplateCreator creator = new PDFTemplateCreator(builder);
    setVisibleSignature(creator.buildPDF(getPdVisibleSignature()));
}