public void onStartPage(PdfWriter writer, Document document) {
    String img = APPLICATION_SERVER_ROOT_PATH + File.separator + "assets" + File.separator + "images" + File.separator + "logo-tp-white.png";
    Image image;
    try {
        image = Image.getInstance(img);
        image.setAlignment(Element.ALIGN_RIGHT);
        image.setAbsolutePosition(20, 790);
        image.scalePercent(7.5f, 7.5f);
        writer.getDirectContent().addImage(image, true);
    } catch (IOException | DocumentException e) {
        log.error("L'image logo-tp-50x50.png a provoqué une erreur.", e);
    }

    ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase(""), 30, 800, 0);
    ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase(Constants.GLOBAL_HOST + " pour réussir votre prochain concours."), 400, 800, 0);
}