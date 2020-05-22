Paint paint = new Paint();
    paint.setTextSize(textSize);
    paint.setColor(textColor);
    paint.setTextAlign(Paint.Align.LEFT);
    paint.setTypeface(Typeface.MONOSPACE);
    int width = (int) (paint.measureText(text) + 0.5f); // round
    float baseline = (int) (-paint.ascent() + 0.5f); // ascent() is negative
    int height = (int) (baseline + paint.descent() + 0.5f);
    Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(image);
    canvas.drawColor(Color.WHITE);
    canvas.drawText(text, 0, baseline, paint);




    Bitmap bmpMonochrome = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
    Canvas canvas1 = new Canvas(bmpMonochrome);
    ColorMatrix ma = new ColorMatrix();
    ma.setSaturation(0);
    Paint paint1 = new Paint();
    paint.setColorFilter(new ColorMatrixColorFilter(ma));
    canvas1.drawBitmap(image, 0, 0, paint1);


    int width2 = bmpMonochrome.getWidth();
    int height2 = bmpMonochrome.getHeight();

    int[] pixels = new int[width2 * height2];
    bmpMonochrome.getPixels(pixels, 0, width2, 0, 0, width2, height2);

    // Iterate over height
    for (int y = 0; y < height2; y++) {
        int offset = y * height2;
        // Iterate over width
        for (int x = 0; x < width2; x++) {
            int pixel = bmpMonochrome.getPixel(x, y);
            int lowestBit = pixel & 0xff;
            if(lowestBit<128)
                bmpMonochrome.setPixel(x,y,Color.BLACK);
            else
                bmpMonochrome.setPixel(x,y,Color.WHITE);
        }
    }