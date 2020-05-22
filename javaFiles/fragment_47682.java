private void printRect(final PDPageContentStream contentStream, final PDRectangle rect) throws IOException {
  contentStream.setStrokingColor(Color.YELLOW);
  contentStream.drawLine(rect.getLowerLeftX(), rect.getLowerLeftY(), rect.getLowerLeftX(), rect.getUpperRightY()); // left
  contentStream.drawLine(rect.getLowerLeftX(), rect.getUpperRightY(), rect.getUpperRightX(), rect.getUpperRightY()); // top
  contentStream.drawLine(rect.getUpperRightX(), rect.getLowerLeftY(), rect.getUpperRightX(), rect.getUpperRightY()); // right
  contentStream.drawLine(rect.getLowerLeftX(), rect.getLowerLeftY(), rect.getUpperRightX(), rect.getLowerLeftY()); // bottom
  contentStream.setStrokingColor(Color.BLACK);
}