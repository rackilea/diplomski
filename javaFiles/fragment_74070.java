Bitmap myBitmap = Bitmap.createBitmap(width, height, ...);
Canvas mCanvas = new Canvas(myBitmap);

// create a black rectangle
final int color = 0xffffffff;
final Paint p1 = new Paint();
final Rect rect = new Rect(0, 0, width, height);
final RectF rectF = new RectF(rect);

// draw it to the canvas
mCanvas.drawARGB(0, 0, 0, 0);
p1.setColor(color);
mCanvas.drawRect(rectF, p1);