map = color_wheel.getDrawingCache();
// Add this
if (event.getX() >= map.getWidth() || event.getY() >= map.getHeight())
    return true;
// To here
int pixel = map.getPixel((int)event.getX(),(int)event.getY());