public static Bitmap createBlackAndWhite(Bitmap src) {
    int width = src.getWidth();
    int height = src.getHeight();
    // create output bitmap
    Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());
    // color information
    int A, R, G, B;
    int pixel;

    // scan through all pixels
    for (int x = 0; x < width; ++x) {
        for (int y = 0; y < height; ++y) {
            // get pixel color
            pixel = src.getPixel(x, y);
            A = Color.alpha(pixel);
            R = Color.red(pixel);
            G = Color.green(pixel);
            B = Color.blue(pixel);
            int gray = (int) (0.2989 * R + 0.5870 * G + 0.1140 * B);

            // use 128 as threshold, above -> white, below -> black
            if (gray > 128) 
                gray = 255;
            else
                gray = 0;
            // set new pixel color to output bitmap
            bmOut.setPixel(x, y, Color.argb(A, gray, gray, gray));
        }
    }
    return bmOut;
}