Bitmap myBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
    Canvas myCanvas = new Canvas(myBitmap);
    Paint paint = new Paint();
    Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/myFont.ttf");

    paint.setTypeface(font);
    paint.setStyle(Paint.Style.FILL);
    paint.setColor(...);
    paint.setTextSize(...);
    myCanvas.drawText("Hello World", x, y, paint);