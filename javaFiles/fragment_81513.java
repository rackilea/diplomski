// get the size of the current font
FontMetrics fm = g.getFontMetrics();
int fontAscent = fm.getAscent();

// drawString co-ordinates specify the baseline of the text, so lets 
// tell it to draw at fontAscent pixels below the top of the rectangle.
// Note that the user might have started dragging from any corner of the 
// rectangle, so we need to determine which co-ordinates represent the 
// top-left most point of the rectangle by looking for the lowest value:
int stringX = Math.min(drawStart.x, drawEnd.x);
int stringY = Math.min(drawStart.y, drawEnd.y) + fontAscent;
// To add n pixles of padding between the rectangle edge and the string,
// just add n to the numbers passed in to the drawString() method here:
g.drawString(text, stringX  stringY);