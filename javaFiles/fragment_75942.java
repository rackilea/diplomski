PdfContentByte canvas = writer.getDirectContent();
int origWidth = myPanel.getWidth();
int origHeight = myPanel.getHeight();
PdfTemplate template = canvas.createTemplate(origWidth, origHeight);
Graphics2D g2 = new PdfGraphics2D(template, origWidth, origHeight);
myPanel.paint(g2);
g2.dispose();
Image image = Image.getInstance(template);
float width = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();
image.scaleToFit(width, 1000);
document.add(image)