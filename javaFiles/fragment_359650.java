public void prepareContent(Whatever pdContentStream, String message) {
    pdContentStream.beginText();
    pdContentStream.setFont(boldFont, BOLD_FONT_SIZE);
    pdContentStream.newLineAtOffset(EXHAUST_BEGIN, currentYCoord);
    pdContentStream.showText(messageSource.getMessage(message, null, this.locale));
    pdContentStream.endText();
}