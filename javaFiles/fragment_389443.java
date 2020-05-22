rel.post(new Runnable() { 
@Override
  public void run() {
    centreX = rel.getWidth() / 2;
    centreY = rel.getHeight() / 2;

    Paint paint = new Paint();
    paint.setStyle(Paint.Style.FILL);
    paint.setColor(Color.WHITE);
    Bitmap bg = Bitmap.createBitmap(480, 500, Bitmap.Config.ARGB_8888);
    canvas = new Canvas(bg); 
    rel = (RelativeLayout) findViewById(R.id.relPaint);
    //canvas.drawPaint(paint);
    paint.setColor(Color.parseColor("#CD5C5C"));
    canvas.drawCircle(centreX, centreY, 50, paint);
    int sdk = android.os.Build.VERSION.SDK_INT;
    if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
      rel.setBackgroundDrawable(new BitmapDrawable(getResources(), bg));
    } else {
      rel.setBackground(new BitmapDrawable(getResources(), bg));
    }
  }
});