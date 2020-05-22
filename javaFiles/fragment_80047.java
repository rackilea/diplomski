public void pixmapMask(Pixmap pixmap, Pixmap mask, Pixmap result, boolean invertMaskAlpha){
    int pixmapWidth = pixmap.getWidth();
    int pixmapHeight = pixmap.getHeight();
    Color pixelColor = new Color();
    Color maskPixelColor = new Color();

    Pixmap.Blending blending = Pixmap.getBlending();
    Pixmap.setBlending(Blending.None);
    for (int x=0; x<pixmapWidth; x++){
        for (int y=0; y<pixmapHeight; y++){
            Color.rgba8888ToColor(pixelColor, pixmap.getPixel(x, y));                           // get pixel color
            Color.rgba8888ToColor(maskPixelColor, mask.getPixel(x, y));                         // get mask color

            maskPixelColor.a = (invertMaskAlpha) ? 1.0f-maskPixelColor.a : maskPixelColor.a;    // IF invert mask
            pixelColor.a = pixelColor.a * maskPixelColor.a;                                     // multiply pixel alpha * mask alpha
            result.setColor(pixelColor);
            result.drawPixel(x, y);
        }
    }
    Pixmap.setBlending(blending);
}