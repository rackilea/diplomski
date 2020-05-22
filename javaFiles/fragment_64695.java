/** Fills a circle with the center at x,y and a radius using the current color.
 * 
 * @param x The x-coordinate of the center
 * @param y The y-coordinate of the center
 * @param radius The radius in pixels */

public void fillCircle (int x, int y, int radius) 
{
    pixmap.fillCircle(x, y, radius, color);
}