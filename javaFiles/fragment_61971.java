public Bitmap applyPieMask(Bitmap src, float startAngle, float sweepAngle) {
    int width = src.getWidth();
    int height = src.getHeight();

    //create bitmap mask with the same dimension of the src bitmap
    Bitmap mask = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(mask);
    canvas.drawColor(0x00000000);//fill mask bitmap with transparent black!

    //init mask paint
    Paint maskPaint = new Paint();
    maskPaint.setColor(0xFFFFFFFF);//pick highest value for bitwise AND operation
    maskPaint.setAntiAlias(true);

    //choose entire bitmap as a rect
    RectF rect = new RectF(0, 0, width, height);
    canvas.drawArc(rect, startAngle, sweepAngle, true, maskPaint);//mask the pie


    Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            //combine src color and mask to gain the result color
            int color = mask.getPixel(i, j) & src.getPixel(i, j);
            result.setPixel(i, j, color);
        }
    }
    return result;
}