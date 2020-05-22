// get metrics from the graphics
FontMetrics metrics = graphics.getFontMetrics(font);
// get the height of a line of text in this font and render context
int hgt = metrics.getHeight();
// get the advance of my text in this font and render context
int adv = metrics.stringWidth(text);
// calculate the size of a box to hold the text with some padding.
Dimension size = new Dimension(adv+2, hgt+2);