Bitmap bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);    
Canvas canvas = new Canvas(bitmap);
Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
paint.setColor(Color.BLACK);
canvas.drawBitmap(yourBitmap, 0, 0, paint) ; //Draw bitmap 
canvas.drawCircle(50, 50, 10, paint);        //Draw Circle
imageView.setImageBitmap(bitmap);