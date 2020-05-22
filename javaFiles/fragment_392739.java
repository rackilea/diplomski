class ExtSigBuilder extends PDVisibleSigBuilder
{
    String fontName;

    public void createImageForm(PDResources imageFormResources, PDResources innerFormResource,
            PDStream imageFormStream, PDRectangle formrect, AffineTransform affineTransform, PDJpeg img)
            throws IOException
    {
        super.createImageForm(imageFormResources, innerFormResource, imageFormStream, formrect, affineTransform, img);

        PDFont font = PDType1Font.HELVETICA;
        fontName = getStructure().getImageForm().getResources().addFont(font);

        logger.info("Added font to image form: " + fontName);
    }

    public void injectAppearanceStreams(PDStream holderFormStream, PDStream innterFormStream, PDStream imageFormStream,
            String imageObjectName, String imageName, String innerFormName, PDVisibleSignDesigner properties)
            throws IOException
    {
        super.injectAppearanceStreams(holderFormStream, innterFormStream, imageFormStream, imageObjectName, imageName, innerFormName, properties);

        String imgFormComment = "q " + 100 + " 0 0 50 0 0 cm /" + imageName + " Do Q\n";
        String text = "BT /" + fontName + " 10 Tf (Hello) Tj ET\n";
        appendRawCommands(getStructure().getImageFormStream().createOutputStream(), imgFormComment + text);

        logger.info("Added text commands to image form: " + text);
    }
}