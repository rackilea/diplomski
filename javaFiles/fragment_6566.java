int size = 10; //minimize  as much as you want
if(path != null){
     Bitmap bitmapOriginal = BitmapFactory.decodeFile(pathath);
     Bitmap bitmapsimplesize = Bitmap.createScaledBitmap(bitmapOriginal,bitmapOriginal.getWidth() / size, bitmapOriginal.getHeight() / size, true);
     bitmapOriginal.recycle();
     img1.setImageBitmap(bitmapsimplesize);

}