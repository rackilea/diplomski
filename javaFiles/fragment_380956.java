int[] pixels = new int[width * height];
bmOut.getPixels(pixels, 0, width, 0, 0, width, height);
// scan through all pixels
for(int i = 0; i < width * height; i++) {
    // get pixel color
    // pixel = src.getPixel(x, y);
    pixel = pixels[i];
    A = Color.alpha(pixel);
    // apply filter contrast for every channel R, G, B
    R = Color.red(pixel);
    R = (int)(((((R / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
    if(R < 0) { R = 0; }
    else if(R > 255) { R = 255; }

    G = Color.green(pixel);
    G = (int)(((((G / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
    if(G < 0) { G = 0; }
    else if(G > 255) { G = 255; }

    B = Color.blue(pixel);
    B = (int)(((((B / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
    if(B < 0) { B = 0; }
    else if(B > 255) { B = 255; }

    // set new pixel color to output bitmap
    pixels[i] = Color.argb(A, R, G, B);
}
bmOut.setPixels(pixels, 0, width, 0, 0, width, height);