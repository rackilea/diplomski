iv = (ImageView) findViewById(R.id.ivEdit);
    Bitmap bmp = BitmapFactory.decodeFile(path);
    Bitmap temp = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), Config.RGB_565);
    c = new Canvas(temp);
    c.drawBitmap(bmp, 0, 0, null);
    iv.setImageBitmap(temp);