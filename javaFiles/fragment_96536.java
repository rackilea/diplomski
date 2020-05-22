Bitmap result = Bitmap.createBitmap(topLayer.getWidth(), topLayer.getHeight(), Config.ARGB_8888);
Canvas mCanvas = new Canvas(result);
Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
mCanvas.drawBitmap(resizedBottom, 0, 0, null);
mCanvas.drawBitmap(topLayer, 0, 0, paint);
paint.setXfermode(null);