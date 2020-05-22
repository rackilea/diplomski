@Override
 public void draw(Canvas canvas, MapView mapview, boolean shadow) {
        super.draw(canvas, mapview, shadow);
            paint = new Paint();
            paint.setAntiAlias(true);
            paint.setARGB(80,0,0,255);
            canvas.drawCircle( x,y,radius, paint);
 }//met