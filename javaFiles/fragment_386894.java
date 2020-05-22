BitmapFactory.Options opt = new BitmapFactory.Options();
opt.inDither = true;
opt.inPreferredConfig = Bitmap.Config.ARGB_8888;
byte[] imageByteArray = getImageByteArray();
Bitmap bitmap = BitmapFactory.decodeByteArray(imageByteArray, 0, imageByteArray.length, opt);
imageView.setImageBitmap(bitmap);