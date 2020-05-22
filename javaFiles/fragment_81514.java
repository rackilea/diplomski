// Note that you need to do this BEFORE you set drawStart and drawEnd to 
// null, so move the lines where that is done to below these lines:
int stringX = Math.min(drawStart.x, drawEnd.x);
int stringY = Math.min(drawStart.y, drawEnd.y);

// now it's safe to discard these points:
drawStart = null;
drawEnd = null;

// Now save the string and its position in the list so that it can be 
// redrawn every time paint() is called:
strings.add(new DrawnString(text, new Point(stringX, stringY)));

// Now we can call repaint():
repaint();