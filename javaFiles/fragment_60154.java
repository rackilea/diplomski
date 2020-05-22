/**
 * Contracts a Rectangle to enable it to be highlighted.
 * 
 * @return A contracted Highlight Rectangle
 */
private Rectangle contractHighlight(Rectangle highlight){
    int x = highlight.x + 1;
    int y = highlight.y + 1;
    int width = highlight.width -2;
    int height = highlight.height - 2;
    return new Rectangle(x, y, width, height);
}