String title = "This is my wonderful title!"; // Or whatever title you want.
int marginTop = 30; // Or whatever margin you want.

PDDocument document = new PDDocument();
PDPage page = new PDPage()
PDPageStreamContent stream = new PDPageContentStream(document, page);
PDFont font = PDType1Font.HELVETICA_BOLD; // Or whatever font you want.

int fontSize = 16; // Or whatever font size you want.
float titleWidth = font.getStringWidth(title) / 1000 * fontSize;
float titleHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;

stream.beginText();
stream.setFont(font, fontSize);
stream.moveTextPositionByAmount((page.getMediaBox().getWidth() - titleWidth) / 2, page.getMediaBox().getHeight() - marginTop - titleheight);
stream.drawString(title);
stream.endText();
stream.close();