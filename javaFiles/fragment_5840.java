float r = Color.decode(colourOne).getRed();
float g = Color.decode(colourOne).getGreen();
float b = Color.decode(colourOne).getBlue();
float r2 = Color.decode(colourTwo).getRed();
float g2 = Color.decode(colourTwo).getGreen();
float b2 = Color.decode(colourTwo).getBlue();
float interp, newR, newG, newB;

for (int x = 0; x < width; x++)
{
    for (int y = 0; y < height; y++)
    {
        interp = (float) (x + y) / (float) (width + height);
        newR = r * (1 - interp) + r2 * interp;
        newG = g * (1 - interp) + g2 * interp;
        newB = b * (1 - interp) + b2 * interp;

        pixels[x + y * width] = (int) (Math.floor(newR) * 0x10000 + Math.floor(newG) * 0x100 + Math.floor(newB));
    }
}