private BufferedImage loadBufferedImage(InputStream inputStream) throws IOException, BadElementException {
    byte[] imageBytes = IOUtils.toByteArray(inputStream);
    BufferedImage incorrectImage = ImageIO.read(new ByteArrayInputStream(imageBytes));

    if (incorrectImage.getColorModel() instanceof ComponentColorModel) {

        // Java does not respect the color profile embedded in a component based image, so if there is a color
        // profile, detected using iText, then create a buffered image with the correct profile.
        Image iTextImage = Image.getInstance(imageBytes);
        com.itextpdf.text.pdf.ICC_Profile iTextProfile = iTextImage.getICCProfile();

        if (iTextProfile == null) {
            // If no profile is present than the image should be processed as is.
            return incorrectImage;
        } else {
            // If there is a profile present then create a buffered image with the profile embedded.
            byte[] profileData = iTextProfile.getData();
            ICC_Profile profile = ICC_Profile.getInstance(profileData);
            ICC_ColorSpace ics = new ICC_ColorSpace(profile);

            boolean hasAlpha = incorrectImage.getColorModel().hasAlpha();
            boolean isAlphaPremultiplied = incorrectImage.isAlphaPremultiplied();
            int transparency = incorrectImage.getTransparency();
            int transferType = DataBuffer.TYPE_BYTE;
            ComponentColorModel ccm = new ComponentColorModel(ics, hasAlpha, isAlphaPremultiplied, transparency, transferType);
            return new BufferedImage(ccm, incorrectImage.copyData(null), isAlphaPremultiplied, null);
        }
    }
    else if (incorrectImage.getColorModel() instanceof IndexColorModel) {
        return incorrectImage;
    }
    else {
        throw new UnsupportedEncodingException("Unsupported color model type.");
    }
}