// Have your variables like this
ImageView background;
Bitmap bitmap;
Canvas canvas;

// Associate them to the respective views
background = (ImageView) findViewById(R.id.Background);
bitmap = Bitmap.createBitmap(500,500, Bitmap.Config.ARGB_8888);
Canvas canvas = new Canvas();
Paint paint = new Paint();
paint.setStyle(Paint.Style.FILL);
paint.setColor(Color.BLUE);

// instead of creating a new canvas, just update the already existing with your bitmap
canvas.setBitmap(bitmap);
canvas.drawCircle(point0,point1,10,paint);
background.setImageBitmap(bitmap)