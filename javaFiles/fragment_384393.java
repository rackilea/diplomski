Font font=new Font("Sans,0,20); //Name, type(none, bold, italic), size
Graphics2D imagegraphics=imagebuffer.createGraphics();
imagegraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //enable antialiasing
imagegraphics.setFont(font);
imagegraphics.setColor(Color.BLACK);
String yourtext="Fighter";
int h=imagegraphics.getFontMetrics().getHeight();
int w=imagegraphics.getFontMetrics().stringWidth(yourtext);
imagegraphics.drawString(yourtext,5,h); //Draw text upper left corner, note that y-value is the bottom line of the string