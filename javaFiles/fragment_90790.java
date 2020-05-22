// Note: I've changed the name of the third parameter from xoffset to yOffset
public void draw(Render render, int xOffset, int yOffset) {
    for (int y = 0; y < render.height; y++) {
        int yPix = height + yOffset;
        pixels[xPix + yPix * width] = Render.pixels[x + y * render.width]; 
    }
}